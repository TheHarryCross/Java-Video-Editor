package asg.jcodec.moovtool.streaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import asg.jcodec.common.IOUtils;
import asg.jcodec.containers.mp4.MP4Util;
import asg.jcodec.containers.mp4.boxes.MovieBox;
import asg.jcodec.movtool.streaming.ConcurrentMovieRangeService;
import asg.jcodec.movtool.streaming.MovieRange;
import asg.jcodec.movtool.streaming.VirtualMovie;
import asg.jcodec.movtool.streaming.tracks.FilePool;
import asg.jcodec.movtool.streaming.tracks.RealTrack;

public class TestConcurrentMovieRangeService {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Syntax: <movie.mov>");
            return;
        }
        File file = new File(args[0]);
        FilePool fp = new FilePool(file, 10);
        MovieBox movie = MP4Util.parseMovie(file);

        RealTrack vt = new RealTrack(movie, movie.getVideoTrack(), fp);
        VirtualMovie vm = new VirtualMovie(vt);
        InputStream is = new MovieRange(vm, 0, vm.size());
        File ref = File.createTempFile("cool", "super");
        ref.deleteOnExit();
        FileOutputStream tmpOs = new FileOutputStream(ref);
        IOUtils.copy(is, tmpOs);
        is.close();
        tmpOs.close();

        ConcurrentMovieRangeService cmrs = new ConcurrentMovieRangeService(vm, 2);
        ExecutorService tp = Executors.newFixedThreadPool(20, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                thread.setDaemon(true);
                return thread;
            }
        });

        Future[] ff = new Future[1000];
        for (int i = 0; i < 1000; i++) {
            ff[i] = tp.submit(new OneTest(vm, ref, cmrs));
        }
        for (int i = 0; i < 1000; i++) {
            try {
                ff[i].get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static class OneTest implements Runnable {
        private VirtualMovie vm;
        private File ref;
        private ConcurrentMovieRangeService cmrs;

        public OneTest(VirtualMovie vm, File ref, ConcurrentMovieRangeService cmrs) {
            this.vm = vm;
            this.ref = ref;
            this.cmrs = cmrs;
        }

        public void run() {
            try {
                long size = vm.size();

                long from = (long) (Math.random() * size);
                long to = from + (long) (Math.random() * (size - from));

                System.out.println("RANGE: " + from + " - " + to);

                InputStream is1 = cmrs.getRange(from, to);

                FileChannel in = new FileInputStream(ref).getChannel();
                in.position(from);
                InputStream is2 = Channels.newInputStream(in);
                byte[] buf1 = new byte[4096], buf2 = new byte[4096];
                int b, ii = 0;
                do {
                    b = is1.read(buf1);
                    int b2 = is2.read(buf2);
                    if (b != -1) {
                        for (int k = 0; k < b; k++) {
                            if (buf1[k] != buf2[k])
                                throw new RuntimeException("[" + (ii + k) + "]" + buf1[k] + ":" + buf2[k]);
                        }
                        ii += b;
                    }
                } while (b != -1);
                if (ii != to - from + 1)
                    throw new RuntimeException("Read less [" + ii + " < " + (to - from + 1));
                is1.close();
                is2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

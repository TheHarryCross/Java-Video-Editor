package asg.jcodec.containers.mkv.elements;

import java.util.Arrays;

import asg.jcodec.containers.mkv.Reader;
import asg.jcodec.containers.mkv.Type;
import asg.jcodec.containers.mkv.ebml.MasterElement;

public class TrackEntry extends MasterElement {

    public TrackEntry(byte[] type) {
        super(type);
        if (!Arrays.equals(Type.TrackEntry.id, type))
            throw new IllegalArgumentException(Reader.printAsHex(type));
    }

}

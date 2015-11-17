package asg.jcodec.common;

import java.io.IOException;
import java.nio.ByteBuffer;

import asg.jcodec.common.model.AudioBuffer;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * @author The JCodec project
 * 
 */
public interface AudioDecoder {
    AudioBuffer decodeFrame(ByteBuffer frame, ByteBuffer dst) throws IOException;
}

package asg.jcodec.codecs.h264;

import java.nio.ByteBuffer;

import junit.framework.Assert;

import org.junit.Test;

import asg.jcodec.codecs.common.biari.MDecoder;
import asg.jcodec.codecs.h264.io.CABAC;
import asg.jcodec.codecs.h264.io.model.SliceType;

public class TestMDecoder {

    @Test
    public void testMDecoder() {
        short[] data = { 0xca, 0x3f, 0xd3, 0x8b, 0x71, 0x5a, 0x8f, 0x7f, 0xff, 0xea, 0x8d, 0x39, 0x7d, 0x60, 0x6, 0x45, 0x10,
                0x97, 0x3f, 0x83, 0x4c, 0xb6, 0xa6, 0x5e, 0xc3, 0xc5, 0x50, 0xcc, 0xdd, 0x1a, 0xf2, 0x73, 0x1e, 0x62,
                0xe7, 0x3c, 0x8c, 0x1, 0xaa, 0xce, 0xf8, 0xf2, 0xae, 0x2b, 0xf2, 0xdd, 0x78, 0x38, 0xf7, 0xa0, 0xd7,
                0xb, 0x8b, 0xef, 0xbc, 0xd4, 0x8b, 0xbc, 0xe6, 0x7a, 0x9, 0x3b, 0xa0, 0xa, 0x38, 0x4e, 0x35, 0xb2,
                0x5f, 0x7a, 0x30, 0x32, 0x19, 0x2b, 0x33, 0x36, 0xc, 0x85, 0x52, 0x4e, 0xfd, 0x83, 0x18, 0x96, 0xd8,
                0x53, 0x6d, 0xdc, 0xff, 0xd4, 0xed, 0xb6, 0xbf, 0x53, 0xb2, 0xe9, 0x54 };
        int[] m = { 3, 399, 68, 68, 68, 68, 68, 68, 69, 69, 69, 68, 69, 69, 69, 68, 69, 69, 69, 68, 68, 69, 69, 69, 68,
                68, 69, 69, 69, 68, 69, 69, 69, 68, 69, 69, 69, 68, 69, 69, 69, 68, 69, 69, 69, 64, 73, 73, 73, 73, 77,
                81, 60, 96, 134, 195, 248, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, 252, -1, 96, 96, 93,
                134, 195, 135, 196, 136, 197, 137, 198, 138, 199, 139, 200, 140, 201, 141, 202, 142, 203, 143, 144,
                145, 206, 146, 207, 248, -1, 249, -1, 250, -1, 251, -1, 251, 252, -1, 247, 253, 253, -1, 247, 254, -1,
                247, -1, 247, -1, 247, 255, 255, 255, -1, 247, 256, -1, 95, 134, 195, 135, 196, 136, 197, 137, 198,
                138, 199, 139, 140, 141, 142, 203, 143, 144, 145, 206, 146, 147, 148, 209, 248, -1, 249, -1, 250, -1,
                251, 252, -1, 247, -1, 247, 253, -1, 247, 254, -1, 247, 255, -1, 96, 134, 195, 135, 136, 197, 137, 198,
                138, 139, 140, 141, 142, 143, 204, 248, -1, 249, -1, 250, -1, 251, -1, 96, 134, 195, 135, 196, 136,
                197, 137, 198, 138, 199, 139, 200, 140, 141, 202, 142, 203, 143, 204, 144, 145, 206, 248, -1, 249, -1,
                250, -1, 251, -1, 251, -1, 251, -1, 251, -1, 251, 252, 252, -1, 247, -1, 247, 253, -1, 96, 134, 195,
                135, 136, 197, 137, 198, 138, 199, 139, 200, 140, 141, 142, 203, 143, 204, 144, 205, 145, 146, 207,
                248, -1, 249, -1, 250, -1, 251, -1, 251, -1, 251, -1, 251, 252, -1, 247, 253, 253, -1, 247, 254, -1,
                94, 134, 195, 135, 196, 136, 197, 137, 198, 138, 199, 139, 200, 140, 201, 141, 202, 142, 203, 143, 204,
                248, -1, 249, -1, 250, -1, 251, -1, 251, -1, 251, 252, 252, 252, 252, -1, 247, -1, 247, 253, 253, 253,
                253, 253, 253, -1, 247, 254, 254, 254, 254, 254, 254, -1, 247, 255, 255, 255, 255, 255, 255, 255, 255,
                -1, 96, 134, 195, 135, 196, 136, 197, 137, 198, 138, 139, 200, 140, 201, 141, 202, 142, 203, 143, 144,
                145, 206, 146, 207, 248, -1, 249, -1, 250, -1, 251, 252, -1, 247, -1, 247, 253, -1, 247, 254, 254, 254,
                254, -1, 247, 255, -1, 247, -1, 247, 256, 256, -1, 96, 134, 195, 135, 196, 136, 137, 138, 139, 140,
                201, 248, 252, -1, 247, 253, 253, 253, 253, 253, 253, 253, -1, 247, 254, 254, -1, 96, 134, 195, 135,
                196, 136, 137, 138, 139, 200, 140, 201, 248, -1, 249, 252, -1, 247, 253, 253, -1, 247, 254, 254, 254,
                254, 254, 254, 254, 254, -1, 96, 134, 195, 135, 136, 197, 137, 198, 138, 199, 139, 200, 140, 201, 141,
                202, 142, 203, 143, 144, 145, 206, 248, -1, 249, -1, 250, -1, 251, -1, 251, -1, 251, -1, 251, -1, 251,
                -1, 251, -1, 96, 134, 195, 135, 196, 136, 137, 138, 139, 140, 141, 202, 248, -1, 249, -1, 250, 252, -1,
                96, 134, 195, 135, 136, 197, 137, 138, 199, 139, 200, 140, 141, 202, 142, 143, 144, 145, 146, 207, 147,
                208, 248, -1, 249, -1, 250, -1, 251, -1, 251, -1, 251, -1, 251, -1, 96, 134, 135, 136, 197, 137, 138,
                139, 200, 140, 201, 141, 202, 142, 143, 144, 145, 146, 207, 248, -1, 249, -1, 250, 252, -1, 247, 253,
                -1, 247, -1, 100, 149, 210, 150, 211, 151, 212, 258, 262, 262, -1, 257, 263, 263, 263, 263, 263, 263,
                -1, 257, 264, -1, 257, 265, 265, 265, 265, -1, 100, 149, 210, 150, 211, 151, 212, 258, 262, 262, 262,
                -1, 257, 263, 263, 263, -1, 257, 264, 264, 264, 264, 264, 264, 264, -1, 104, 152, 213, 267, -1, 104,
                152, 213, 153, 214, 154, 215, 155, 216, 156, 157, 158, 159, 220, 160, 221, 161, 222, 267, -1, 268, 271,
                271, 271, -1, 266, -1, 266, -1, 266, -1, 266, 272, 272, -1, 266, -1, 104, 152, 153, 154, 155, 216, 156,
                217, 157, 218, 158, 219, 267, -1, 268, -1, 269, -1, 270, 271, -1, 104, 152, 213, 153, 154, 155, 216,
                156, 157, 158, 219, 159, 220, 160, 161, 162, 223, 163, 224, 164, 225, 267, -1, 268, -1, 269, -1, 270,
                -1, 270, -1, 270, -1, 270, -1, 104, 103, 152, 213, 153, 214, 154, 215, 155, 216, 156, 157, 158, 159,
                220, 160, 221, 161, 222, 267, -1, 268, -1, 269, -1, 270, -1, 270, -1, 270, -1, 270, -1, 102, 152, 153,
                154, 155, 216, 156, 217, 157, 218, 158, 219, 159, 160, 161, 222, 267, -1, 268, -1, 269, -1, 270, -1,
                270, 271, -1, 104, 152, 213, 153, 154, 155, 216, 156, 157, 158, 219, 159, 220, 160, 161, 162, 223, 163,
                224, 164, 225, 267, -1, 268, -1, 269, -1, 270, -1, 270, -1, 270, -1, 270, -1 };
        int[] out = { 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0,
                0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0,
                1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0,
                1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1,
                0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,
                1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0,
                1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1,
                0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0,
                1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0,
                1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0,
                1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0,
                0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1,
                0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0,
                1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1,
                1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1,
                0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1,
                1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0,
                0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1,
                0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0,
                1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0,
                1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0 };

        int[][] cm = new int[2][1024];

        new CABAC(1).initModels(cm, SliceType.I, 0, 34);
        
        MDecoder decoder = new MDecoder(ByteBuffer.wrap(shortArray2ByteArray(data)), cm);

        for (int i = 0; i < m.length; i++) {
            Assert.assertEquals("Bin " + i, out[i], m[i] == -1 ? decoder.decodeBinBypass() : decoder.decodeBin(m[i]));
        }
    }

    byte[] shortArray2ByteArray(short[] src) {
        byte[] result = new byte[src.length];
        for (int i = 0; i < src.length; i++) {
            result[i] = (byte) src[i];
        }
        return result;
    }
}

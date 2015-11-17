package asg.jcodec.codecs.h264;

import static org.junit.Assert.assertArrayEquals;
import junit.framework.TestCase;

import asg.jcodec.codecs.h264.decode.Intra16x16PredictionBuilder;

public class TestIntra16x16PredictionBuilder extends TestCase {

    public void testVertical() throws Exception {
        int[] expected = new int[] { 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28,
                132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207,
                207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207,
                206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206,
                28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207,
                207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207,
                207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206,
                206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207,
                207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207,
                207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206,
                206, 206, 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205,
                207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206, 28, 132, 205, 207, 207, 207, 207, 207,
                207, 207, 207, 206, 206, 206, 206, 206 };

        int[] top = new int[] { 28, 132, 205, 207, 207, 207, 207, 207, 207, 207, 207, 206, 206, 206, 206, 206 };

        int[] actual = new int[256];
        Intra16x16PredictionBuilder.predictVertical(actual, true, top, 0);

        assertArrayEquals(expected, actual);
    }

    public void testHorizontal() throws Exception {
        int[] expected = new int[] { 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234,
                233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 232, 232, 232, 232,
                232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232,
                232, 232, 232, 232, 232, 232, 232, 232, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234,
                234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234, 234,
                233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233,
                233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 235, 235, 235, 235, 235, 235, 235, 235,
                235, 235, 235, 235, 235, 235, 235, 235, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237,
                237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237, 237,
                204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 204, 165, 165, 165, 165,
                165, 165, 165, 165, 165, 165, 165, 165, 165, 165, 165, 165, 135, 135, 135, 135, 135, 135, 135, 135,
                135, 135, 135, 135, 135, 135, 135, 135, 125, 125, 125, 125, 125, 125, 125, 125, 125, 125, 125, 125,
                125, 125, 125, 125, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114 };

        int[] left = new int[] { 234, 233, 232, 232, 234, 234, 233, 233, 235, 237, 237, 204, 165, 135, 125, 114 };
//        int[] top = new int[] {  231, 231, 231, 231, 229, 227, 223, 221, 209, 207, 203, 201, 202, 202, 202, 202 };

        int[] actual = new int[256];
        Intra16x16PredictionBuilder.predictHorizontal(actual, true, left, 0);

        assertArrayEquals(expected, actual);
    }

    public void testDC() throws Exception {
        int[] expected = new int[] { 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194,
                194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194, 194 };

        int[] left = new int[] { 147, 196, 206, 213, 206, 208, 212, 214, 214, 214, 214, 214, 208, 209, 192, 154 };
        int[] top = new int[] { 132, 182, 204, 202, 210, 210, 210, 210, 210, 210, 183, 130, 136, 189, 194, 178 };

        int[] actual = new int[256];
        Intra16x16PredictionBuilder.predictDC(actual, true, true, left, top, 0);

        assertArrayEquals(expected, actual);
    }

    public void testPlane() throws Exception {

        int[] expected = new int[] { 105, 111, 117, 124, 130, 136, 143, 149, 155, 162, 168, 174, 181, 187, 193, 200,
                104, 110, 116, 123, 129, 135, 142, 148, 154, 161, 167, 173, 180, 186, 192, 199, 103, 109, 115, 122,
                128, 134, 141, 147, 153, 160, 166, 172, 179, 185, 191, 198, 102, 108, 114, 121, 127, 133, 140, 146,
                152, 159, 165, 171, 178, 184, 190, 197, 101, 107, 113, 120, 126, 132, 139, 145, 151, 158, 164, 170,
                177, 183, 189, 196, 100, 106, 112, 119, 125, 131, 138, 144, 150, 157, 163, 169, 176, 182, 188, 195, 99,
                105, 111, 118, 124, 130, 137, 143, 149, 156, 162, 168, 175, 181, 187, 194, 98, 104, 110, 117, 123, 129,
                136, 142, 148, 155, 161, 167, 174, 180, 186, 193, 97, 103, 109, 116, 122, 128, 135, 141, 147, 154, 160,
                166, 173, 179, 185, 192, 96, 102, 108, 115, 121, 127, 134, 140, 146, 153, 159, 165, 172, 178, 184, 191,
                95, 101, 107, 114, 120, 126, 133, 139, 145, 152, 158, 164, 171, 177, 183, 190, 94, 100, 106, 113, 119,
                125, 132, 138, 144, 151, 157, 163, 170, 176, 182, 189, 93, 99, 105, 112, 118, 124, 131, 137, 143, 150,
                156, 162, 169, 175, 181, 188, 92, 98, 104, 111, 117, 123, 130, 136, 142, 149, 155, 161, 168, 174, 180,
                187, 91, 97, 103, 110, 116, 122, 129, 135, 141, 148, 154, 160, 167, 173, 179, 186, 90, 96, 102, 109,
                115, 121, 128, 134, 140, 147, 153, 159, 166, 172, 178, 185 };

        int[] left =  { 97, 94, 88, 86, 92, 92, 92, 92, 91, 99, 100, 94, 96, 89, 79, 76 };
        int[] tl = {122};
        int[] top =  {  110, 95, 108, 158, 199, 199, 199, 199, 204, 202, 196, 193, 199, 202, 206, 208 };

        int[] actual = new int[256];
        Intra16x16PredictionBuilder.predictPlane(actual, true, true, left, top, tl, 0);

        assertArrayEquals(expected, actual);
    }

    public void testPlane2() throws Exception {

        int[] expected = new int[] { 125, 134, 143, 152, 161, 170, 179, 188, 197, 206, 215, 225, 234, 243, 252, 255,
                119, 128, 137, 146, 155, 164, 173, 183, 192, 201, 210, 219, 228, 237, 246, 255, 113, 122, 131, 141,
                150, 159, 168, 177, 186, 195, 204, 213, 222, 231, 240, 249, 108, 117, 126, 135, 144, 153, 162, 171,
                180, 189, 198, 207, 216, 225, 234, 244, 102, 111, 120, 129, 138, 147, 156, 165, 174, 183, 192, 202,
                211, 220, 229, 238, 96, 105, 114, 123, 132, 141, 150, 160, 169, 178, 187, 196, 205, 214, 223, 232, 90,
                99, 108, 118, 127, 136, 145, 154, 163, 172, 181, 190, 199, 208, 217, 226, 85, 94, 103, 112, 121, 130,
                139, 148, 157, 166, 175, 184, 193, 202, 211, 221, 79, 88, 97, 106, 115, 124, 133, 142, 151, 160, 169,
                179, 188, 197, 206, 215, 73, 82, 91, 100, 109, 118, 127, 137, 146, 155, 164, 173, 182, 191, 200, 209,
                67, 76, 85, 95, 104, 113, 122, 131, 140, 149, 158, 167, 176, 185, 194, 203, 62, 71, 80, 89, 98, 107,
                116, 125, 134, 143, 152, 161, 170, 179, 188, 198, 56, 65, 74, 83, 92, 101, 110, 119, 128, 137, 146,
                156, 165, 174, 183, 192, 50, 59, 68, 77, 86, 95, 104, 114, 123, 132, 141, 150, 159, 168, 177, 186, 44,
                53, 62, 72, 81, 90, 99, 108, 117, 126, 135, 144, 153, 162, 171, 180, 39, 48, 57, 66, 75, 84, 93, 102,
                111, 120, 129, 138, 147, 156, 165, 175 };

        int[] left = { 140, 138, 133, 130, 128, 123, 113, 108, 101, 96, 86, 81, 74, 72, 67, 64 };
        int[] tl = {160};
        int[] top =  { 68, 76, 91, 98, 112, 120, 135, 142, 158, 166, 181, 188, 202, 210, 225, 232 };
        

        int[] actual = new int[256];
        Intra16x16PredictionBuilder.predictPlane(actual, true, true, left, top, tl, 0);

        assertArrayEquals(expected, actual);
    }
}
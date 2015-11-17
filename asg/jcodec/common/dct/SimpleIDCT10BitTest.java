package asg.jcodec.common.dct;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SimpleIDCT10BitTest {
    public void testOne() {

        int[] input = new int[] {
                1832, -256, -226, -164, -96, -52, -24, -2, -266, 50, 44, 34, 18, 10, 6, 2, -240, 52, 46, 26, 22, 12, 2,
                -6, -228, 38, 38, 32, 18, 8, -2, 5, -192, 38, 28, 32, 10, 2, 7, 5, -144, 28, 22, 16, 10, 7, 5, 0, -100,
                20, 24, 6, 2, 5, 6, -4, -44, 2, 16, -2, 7, 6, -4, 0
        };

        int output[] = new int[] {
                 64,  64,  63,  63,  64,  64,  65,  64,
                112, 227, 276, 284, 284, 275, 276, 275,
                111, 230, 287, 288, 275, 278, 283, 289,
                108, 224, 283, 277, 288, 285, 272, 268,
                108, 224, 276, 276, 288, 276, 284, 279,
                109, 227, 279, 280, 280, 277, 279, 277,
                112, 228, 280, 292, 285, 275, 284, 285,
                115, 233, 284, 286, 280, 280, 276, 280
        };

        SimpleIDCT10Bit.idct10(input, 0);

        assertArrayEquals(output, input);
    }

    public void testTwo() {

        int[] input = new int[] {
                1196, -75, 10, 0, -5, -10, -10, 0, -140, -65, -10, -5, 5, 5, 0, 5, -105, -75, 20, -10, 20, -10, 10, 5,
                -50, 20, 35, 15, 5, -5, -5, 0, -10, 20, 35, -15, 0, 5, 6, 0, -15, 15, -15, 5, 0, 6, -13, 0, 15, 20, 10,
                -5, 0, -13, 0, -9, -15, 0, -15, -10, 6, 0, 0, -9
        };

        int output[] = new int[] {
                78, 76, 71, 80, 98, 103, 127, 155, 81, 82, 105, 114, 144, 152, 164, 169, 110, 140, 148, 169, 169, 168,
                160, 156, 163, 170, 169, 165, 162, 163, 178, 148, 175, 178, 166, 160, 150, 159, 162, 160, 184, 191,
                156, 151, 166, 169, 166, 162, 142, 148, 143, 160, 170, 163, 167, 155, 154, 159, 162, 151, 157, 167,
                171, 204
        };

        SimpleIDCT10Bit.idct10(input, 0);

        assertArrayEquals(output, input);
    }

    @Test
    public void testThree() {

        int[] input = new int[] {
                2180, 8, 8, -4, 4, 4, -4, 4, 0, 4, -4, 8, 4, 0, 16, 4, 0, 0, -4, 4, 20, 4, -12, 4, 4, 8, -8, -12, -4,
                -4, 0, 0, 0, 0, 4, 8, 0, 0, 0, 0, 24, 4, -8, 24, -4, -5, -15, -6, 4, 8, -8, -16, 15, 10, 0, 0, -8, -16,
                -8, 12, 5, -6, 0, 7
        };

        int output[] = new int[] {
                284, 272, 272, 282, 287, 270, 270, 268, 275, 264, 277, 263, 262, 265, 266, 276, 276, 262, 271, 275,
                277, 271, 271, 273, 285, 288, 274, 268, 267, 285, 279, 268, 263, 266, 276, 257, 264, 271, 269, 275,
                271, 282, 291, 288, 261, 256, 268, 276, 272, 285, 260, 271, 285, 278, 285, 268, 277, 267, 263, 277,
                268, 254, 276, 278
        };

        SimpleIDCT10Bit.idct10(input, 0);

        assertArrayEquals(output, input);
    }

}

package io.github.seekerlee.algo24;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午11:28
 */
public class FractionalIntTrackableTest {
    public static void main(String[] a) {
        FractionalIntTrackable f1 = new FractionalIntTrackable(new FractionalInt(8)   , null);
        FractionalIntTrackable f2 = new FractionalIntTrackable(new FractionalInt(2, 8), null);
        FractionalIntTrackable f3 = new FractionalIntTrackable(new FractionalInt(3, 8), null);
        FractionalIntTrackable f4 = new FractionalIntTrackable(new FractionalInt(0, 8), null);
        FractionalIntTrackable f5 = new FractionalIntTrackable(new FractionalInt(8, 1), null);
        FractionalIntTrackable f6 = new FractionalIntTrackable(new FractionalInt(5, 8), null);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(f6);

        System.out.println();

        System.out.println(f1.subtract(f2).toRichString());
        System.out.println(f2.add(f3).toRichString());
        System.out.println(f3.add(f6));
        System.out.println(f4.multiply(f5));
        System.out.println(f5.divide(f3));
        System.out.println(f6.divide(f6).add(f2));
        System.out.println(f6.divide(f6).add(f5).divide(f3).toRichString());
    }
}

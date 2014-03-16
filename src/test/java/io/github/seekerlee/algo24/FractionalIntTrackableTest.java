package io.github.seekerlee.algo24;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午11:28
 */
public class FractionalIntTrackableTest {
    public static void main(String[] a) {
        TrackableFractionalInt f1 = new TrackableFractionalInt(new FractionalInt(8)   , null);
        TrackableFractionalInt f2 = new TrackableFractionalInt(new FractionalInt(2, 8), null);
        TrackableFractionalInt f3 = new TrackableFractionalInt(new FractionalInt(3, 8), null);
        TrackableFractionalInt f4 = new TrackableFractionalInt(new FractionalInt(0, 8), null);
        TrackableFractionalInt f5 = new TrackableFractionalInt(new FractionalInt(8, 1), null);
        TrackableFractionalInt f6 = new TrackableFractionalInt(new FractionalInt(5, 0), null);

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

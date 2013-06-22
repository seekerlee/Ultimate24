package io.github.seekerlee.algo24;

public class FractionalIntTest {
    public static void main(String[] a) {
        FractionalInt f1 = new FractionalInt(8);
        FractionalInt f2 = new FractionalInt(2, 8);
        FractionalInt f3 = new FractionalInt(3, 8);
        FractionalInt f4 = new FractionalInt(0, 8);
        FractionalInt f5 = new FractionalInt(8, 1);
        FractionalInt f6 = new FractionalInt(5, 8);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(f6);

        System.out.println();

        System.out.println(f1.subtract(f2));
        System.out.println(f2.add(f3));
        System.out.println(f3.add(f6));
        System.out.println(f4.multiply(f5));
        System.out.println(f5.divide(f3));
        System.out.println(f6.divide(f6));
    }
}

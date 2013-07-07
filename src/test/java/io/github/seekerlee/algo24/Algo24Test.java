package io.github.seekerlee.algo24;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sshli
 * Date: 6/25/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Algo24Test {
    public static void main(String[] a) {
        ArrayList<FractionalIntTrackable> input = new ArrayList<FractionalIntTrackable>();
        input.add(new FractionalIntTrackable(new FractionalInt(3)));
        input.add(new FractionalIntTrackable(new FractionalInt(4)));
        input.add(new FractionalIntTrackable(new FractionalInt(8)));
        input.add(new FractionalIntTrackable(new FractionalInt(3)));
        input.add(new FractionalIntTrackable(new FractionalInt(91)));
        input.add(new FractionalIntTrackable(new FractionalInt(97)));
        long t0 = System.currentTimeMillis();
        Algo24 al = new Algo24(input, new FractionalInt(129));
        long t1 = System.currentTimeMillis();

        Set<FractionalIntTrackable> o = al.getOutput();
        for(FractionalIntTrackable t : o) {
            System.out.println(t);
        }
        System.out.println(t1 - t0);
    }
}

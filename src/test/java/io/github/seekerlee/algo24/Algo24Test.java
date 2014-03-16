package io.github.seekerlee.algo24;

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
        long t0 = System.nanoTime();
        Algo24 al = Algo24.newAlgo24(171, 2, 3, 4, 5, 17, 37, 97);
        long t1 = System.nanoTime();

        Set<TrackableFractionalInt> o = al.getOutput();
        for(TrackableFractionalInt t : o) {
            System.out.println(t);
        }
        System.out.println("time:    " + (t1 - t0)/1000000);
        System.out.println("results: " + o.size());

    }
}

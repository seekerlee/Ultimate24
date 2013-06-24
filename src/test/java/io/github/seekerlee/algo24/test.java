package io.github.seekerlee.algo24;

import java.util.*;

/**
 * User: seeker
 * Date: 6/24/13
 * Time: 10:53 PM
 */
class test {
    public static void main(String[] a) {
        ArrayList<StringBuilder> a0 = new ArrayList<StringBuilder>(Arrays.asList(new StringBuilder("a"), new StringBuilder("b"), new StringBuilder("c")));
        ArrayList<StringBuilder> a1 = new ArrayList<StringBuilder>(a0);
        a0.get(0).append("!");
        a0.add(2, null);
        System.out.print(a0);
        System.out.print(a1);
    }
}

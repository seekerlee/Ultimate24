package io.github.seekerlee.algo24;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午9:59
 */
public class Algo24 {
    final Set<FractionalIntTrackable> output = new HashSet<FractionalIntTrackable>();
    final List<FractionalIntTrackable> input;
    final FractionalInt goal;

    public Algo24(List<FractionalIntTrackable> input, FractionalInt goal) {
        // TODO: check input
        this.input = input;
        this.goal = goal;
        doit(input);
    }

    private void doit(List<FractionalIntTrackable> in) {
        // end of recursion
        if (in.size() == 1) {
            if (in.get(0).getFraction().equals(goal)) {
                output.add(in.get(0));
            } else {
                return;
            }
        }
        // in process of recursion
        for (int i = 0; i < in.size() - 1; i ++) {
            for (int j = i + 1; j < in.size(); j++) {

            }
        }
    }

    private class PairedSet<T> {
        private Set<T> remainSet;
    }

    private class Pair {
        private FractionalIntTrackable pairL;
        private FractionalIntTrackable pairR;
        public Pair(FractionalIntTrackable pairL, FractionalIntTrackable pairR) {
            if (pairL.compareTo(pairR) > 0) {
                this.pairL = pairL;
                this.pairR = pairR;
            } else {
                this.pairL = pairR;
                this.pairR = pairL;
            }
        }
    }
}

package io.github.seekerlee.algo24;

import java.math.BigInteger;
import java.util.ArrayList;
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
            }
            return;
        }
        // in process of recursion
        Set<Pair> existP = new HashSet<Pair>();
        for (int i = 0; i < in.size() - 1; i ++) {
            for (int j = i + 1; j < in.size(); j++) {
                Pair p = new Pair(in.get(i), in.get(j));
                if (existP.contains(p)) {
                    continue;
                } else {
                    existP.add(p);
                    List<FractionalIntTrackable> expand = p.expand();
                    for (FractionalIntTrackable f : expand) {
                        List<FractionalIntTrackable> copy = new ArrayList<FractionalIntTrackable>(in);
                        copy.remove(j);
                        copy.remove(i);
                        copy.add(f);
                        doit(copy);
                    }
                }
            }
        }
    }

    public List<FractionalIntTrackable> getInput() {
        return input;
    }

    public Set<FractionalIntTrackable> getOutput() {
        return output;
    }

    public FractionalInt getGoal() {
        return goal;
    }

    private static class Pair {
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

        public List<FractionalIntTrackable> expand() {
            List<FractionalIntTrackable> l = new ArrayList<FractionalIntTrackable>(6);
            l.add(pairL.add(pairR));
            l.add(pairL.subtract(pairR));
            l.add(pairL.multiply(pairR));
            l.add(pairR.subtract(pairL));
            if(!pairL.getNumerator().equals(BigInteger.ZERO)) l.add(pairR.divide(pairL));
            if(!pairR.getNumerator().equals(BigInteger.ZERO)) l.add(pairL.divide(pairR));
            return l;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;

            if (!(o instanceof Pair))
                return false;

            Pair p = (Pair)o;
            return p.pairL.equals(this.pairL) &&  p.pairR.equals(this.pairR);
        }

        @Override
        public int hashCode() {
            return 31 * pairL.hashCode() + pairR.hashCode();
        }
    }
}

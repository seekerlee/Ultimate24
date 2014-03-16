package io.github.seekerlee.algo24;

import java.math.BigInteger;
import java.util.*;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午9:59
 */
public class Algo24 {
    final Set<TrackableFractionalInt> output = new HashSet<>();
    final List<TrackableFractionalInt> input;
    final FractionalInt goal;

    public Algo24(FractionalInt goal, List<TrackableFractionalInt> input) {
        // TODO: check input
        this.input = input;
        this.goal = goal;
        doit(input);
    }

    public static Algo24 newAlgo24(int goal, int... input) {
        ArrayList<TrackableFractionalInt> input2 = new ArrayList<>();
        for(int i : input) {
            input2.add(new TrackableFractionalInt(new FractionalInt(i)));
        }
        return new Algo24(new FractionalInt(goal), input2);
    }

    private void doit(List<TrackableFractionalInt> in) {
        // end of recursion
        if (in.size() == 1) {
            if (in.get(0).getFraction().equals(goal)) {
                output.add(in.get(0));
            }
            return;
        }
        // in process of recursion
        Set<Pair> existP = new HashSet<>();
        for (int i = 0; i < in.size() - 1; i ++) {
            for (int j = i + 1; j < in.size(); j++) {
                Pair p = new Pair(in.get(i), in.get(j));
                if (existP.contains(p)) {
                    continue;
                } else {
                    existP.add(p);
                    List<TrackableFractionalInt> expand = p.expand();
                    for (TrackableFractionalInt f : expand) {
                        List<TrackableFractionalInt> copy = new ArrayList<>(in);
                        copy.remove(j);
                        copy.remove(i);
                        copy.add(f);
                        doit(copy);
                    }
                }
            }
        }
    }

    public List<TrackableFractionalInt> getInput() {
        return input;
    }

    public Set<TrackableFractionalInt> getOutput() {
        return output;
    }

    public FractionalInt getGoal() {
        return goal;
    }

    private static class Pair {
        private final TrackableFractionalInt pairL;
        private final TrackableFractionalInt pairR;
        public Pair(TrackableFractionalInt pairL, TrackableFractionalInt pairR) {
            if (pairL.compareTo(pairR) > 0) {
                this.pairL = pairL;
                this.pairR = pairR;
            } else {
                this.pairL = pairR;
                this.pairR = pairL;
            }
        }

        public List<TrackableFractionalInt> expand() {
            List<TrackableFractionalInt> l = new ArrayList<>(6);
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

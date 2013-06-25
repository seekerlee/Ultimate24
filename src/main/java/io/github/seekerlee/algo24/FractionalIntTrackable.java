package io.github.seekerlee.algo24;

import java.math.BigInteger;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午11:15
 */
public class FractionalIntTrackable implements TrackableArith, Comparable<FractionalIntTrackable>{
    private ArithTracker<FractionalIntTrackable> tracker;
    private FractionalInt fraction;
    public FractionalIntTrackable(FractionalInt fraction, ArithTracker<FractionalIntTrackable> tracker) {
        this.fraction = fraction;
        this.tracker = tracker;
    }

    public FractionalIntTrackable(FractionalInt fraction) {
        this.fraction = fraction;
        this.tracker = null;
    }

    public BigInteger getDenominator() {
        return fraction.getDenominator();
    }

    public BigInteger getNumerator() {
        return fraction.getNumerator();
    }

    public FractionalIntTrackable multiply(FractionalIntTrackable val) {
        return new FractionalIntTrackable(fraction.multiply(val.getFraction()), new ArithTracker<FractionalIntTrackable>(this, val, Operator.MULTIPLY));
    }

    public FractionalIntTrackable divide(FractionalIntTrackable val) {
        return new FractionalIntTrackable(fraction.divide(val.getFraction()), new ArithTracker<FractionalIntTrackable>(this, val, Operator.DIVIDE));
    }

    public FractionalIntTrackable subtract(FractionalIntTrackable val) {
        return new FractionalIntTrackable(fraction.subtract(val.getFraction()), new ArithTracker<FractionalIntTrackable>(this, val, Operator.SUBTRACT));
    }

    public FractionalIntTrackable add(FractionalIntTrackable val) {
        return new FractionalIntTrackable(fraction.add(val.getFraction()), new ArithTracker<FractionalIntTrackable>(this, val, Operator.ADD));
    }

    @Override
    public String toString() {
        if(tracker == null) {
            return fraction.toString();
        } else {
            return "(" + tracker.getlValue() + " " + tracker.getOp() + " " + tracker.getrValue() + ")";
        }
    }

    public String toRichString() {
        if(tracker == null) {
            return this.toString();
        } else {
            return tracker.getlValue() + " " + tracker.getOp() + " " + tracker.getrValue() + " " + Operator.EQUAL + " " + fraction.toString();
        }
    }

    public FractionalInt getFraction() {
        return fraction;
    }

    @Override
    public ArithTracker getArithTracker() {
        return this.tracker;
    }

    @Override
    public int compareTo(FractionalIntTrackable o) {
        return this.subtract(o).getDenominator().compareTo(BigInteger.ZERO);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);    //TODO: implement strict compare include tracker
    }
}

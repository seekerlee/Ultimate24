package io.github.seekerlee.algo24;

import java.math.BigInteger;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午11:15
 */
public class FractionalIntTrackable implements TrackableArith{
    private ArithTracker<FractionalIntTrackable> tracker;
    private FractionalInt fraction;
    public FractionalIntTrackable(FractionalInt fraction, ArithTracker<FractionalIntTrackable> tracker) {
        this.fraction = fraction;
        this.tracker = tracker;
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
        return tracker.getlValue() + " " + tracker.getOp() + " " + tracker.getrValue() + " " + Operator.EQUAL + " " + fraction.toString();
    }

    public FractionalInt getFraction() {
        return fraction;
    }

    @Override
    public ArithTracker getArithTracker() {
        return this.tracker;
    }

}

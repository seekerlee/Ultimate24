package io.github.seekerlee.algo24;

import java.math.BigInteger;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午11:15
 */
public class TrackableFractionalInt implements TrackableArith, Comparable<TrackableFractionalInt>{
    private ArithTracker<TrackableFractionalInt> tracker;
    private FractionalInt fraction;
    public TrackableFractionalInt(FractionalInt fraction, ArithTracker<TrackableFractionalInt> tracker) {
        this.fraction = fraction;
        this.tracker = tracker;
    }

    public TrackableFractionalInt(FractionalInt fraction) {
        this.fraction = fraction;
        this.tracker = null;
    }

    public BigInteger getDenominator() {
        return fraction.getDenominator();
    }

    public BigInteger getNumerator() {
        return fraction.getNumerator();
    }

    public TrackableFractionalInt multiply(TrackableFractionalInt val) {
        return new TrackableFractionalInt(fraction.multiply(val.getFraction()), new ArithTracker<>(this, val, Operator.MULTIPLY));
    }

    public TrackableFractionalInt divide(TrackableFractionalInt val) {
        return new TrackableFractionalInt(fraction.divide(val.getFraction()), new ArithTracker<>(this, val, Operator.DIVIDE));
    }

    public TrackableFractionalInt subtract(TrackableFractionalInt val) {
        return new TrackableFractionalInt(fraction.subtract(val.getFraction()), new ArithTracker<>(this, val, Operator.SUBTRACT));
    }

    public TrackableFractionalInt add(TrackableFractionalInt val) {
        return new TrackableFractionalInt(fraction.add(val.getFraction()), new ArithTracker<>(this, val, Operator.ADD));
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
    public int compareTo(TrackableFractionalInt o) {
        return this.subtract(o).getDenominator().compareTo(BigInteger.ZERO);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof TrackableFractionalInt))
            return false;

        TrackableFractionalInt f = (TrackableFractionalInt) o;
        boolean eq = this.fraction.equals(f.fraction);
        if(!eq) return false;
        if(this.tracker == null && f.tracker == null) return true;
        if(this.tracker == null || f.tracker == null) return false;

        return this.tracker.equals(f.tracker);
    }

    @Override
    public int hashCode() {
        if(this.tracker != null) {
            return this.tracker.hashCode() * 31 + this.fraction.hashCode();
        } else {
            return this.fraction.hashCode();
        }
    }
}

package io.github.seekerlee.algo24;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午10:03
 */
public class ArithTracker<T extends TrackableArith> {
    private final T lValue;
    private final T rValue;
    private final Operator op;

    public ArithTracker(T lValue, T rValue, Operator op) {
        if (lValue == null || rValue == null || op == null) throw new IllegalArgumentException("null argument!");
        this.lValue = lValue;
        this.rValue = rValue;
        this.op = op;
    }

    public T getlValue() {
        return lValue;
    }

    public T getrValue() {
        return rValue;
    }

    public Operator getOp() {
        return op;
    }
}

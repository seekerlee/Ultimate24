package io.github.seekerlee.algo24;

/**
 * User: seeker
 * Date: 13-6-23
 * Time: 上午10:09
 */
public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL;

    @Override
    public final String toString() {
        switch (this) {
            case ADD:      return "+";
            case SUBTRACT: return "-";
            case MULTIPLY: return "*";
            case DIVIDE:   return "/";
            case EQUAL:    return "=";
            default: throw new IllegalArgumentException();
        }
    }
}

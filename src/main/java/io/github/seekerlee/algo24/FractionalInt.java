package io.github.seekerlee.algo24;

import java.math.BigInteger;

/**
 * Created with BigIntegerelliJ IDEA.
 * User: seeker
 * Date: 13-6-22
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */
public class FractionalInt {
    private BigInteger numerator;
    private BigInteger denominator;

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public FractionalInt(final BigInteger numerator, final BigInteger denominator) {
        if(numerator == null || denominator == null) throw new IllegalArgumentException("null input!");
        if(denominator.equals(BigInteger.ZERO)) throw new ArithmeticException("denominator == 0!");
        this.numerator = numerator;
        this.denominator = denominator;
        selfReduce();
    }
    public FractionalInt(final int numerator, final int denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }
    public FractionalInt(final long numerator, final long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }
    public FractionalInt(final BigInteger numerator) {
        this(numerator, BigInteger.ONE);
    }
    public FractionalInt(final int numerator) {
        this(BigInteger.valueOf(numerator));
    }
    public FractionalInt(final long numerator) {
        this(BigInteger.valueOf(numerator));
    }

    private void selfReduce() {
        final BigInteger gcd = this.numerator.gcd(this.denominator);
        this.numerator = this.numerator.divide(gcd);
        this.denominator = this.denominator.divide(gcd);
    }

    public FractionalInt add(final FractionalInt val) {
        BigInteger newNumerator = this.getNumerator().multiply(val.getDenominator()).add(val.getNumerator().multiply(this.getDenominator()));
        BigInteger newDenominator = this.getDenominator().multiply(val.getDenominator());
        return new FractionalInt(newNumerator, newDenominator);
    }

    public FractionalInt subtract(final FractionalInt val) {
        BigInteger newNumerator = this.getNumerator().multiply(val.getDenominator()).subtract(val.getNumerator().multiply(this.getDenominator()));
        BigInteger newDenominator = this.getDenominator().multiply(val.getDenominator());
        return new FractionalInt(newNumerator, newDenominator);
    }

    public FractionalInt multiply(final FractionalInt val) {
        BigInteger newNumerator = this.getNumerator().multiply(val.getNumerator());
        BigInteger newDenominator = this.getDenominator().multiply(val.getDenominator());
        return new FractionalInt(newNumerator, newDenominator);
    }

    public FractionalInt divide(final FractionalInt val) {
        BigInteger newNumerator = this.getNumerator().multiply(val.getDenominator());
        BigInteger newDenominator = this.getDenominator().multiply(val.getNumerator());
        return new FractionalInt(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        if(this.denominator.equals(BigInteger.ONE)) {
            return this.numerator.toString();
        } else {
            return this.numerator.toString() + '/' + this.denominator.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FractionalInt that = (FractionalInt) o;

        if (!denominator.equals(that.denominator)) return false;
        if (!numerator.equals(that.numerator)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator.hashCode();
        result = 31 * result + denominator.hashCode();
        return result;
    }
}

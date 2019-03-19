package com.baranov.tdd;

public class Franc extends Money {

    Franc(final int amount, final String currency) {
        super(amount, currency);
    }

    public Money times(final int multiplier) {
        return Money.franc(amount * multiplier);
    }
}

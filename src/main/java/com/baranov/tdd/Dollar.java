package com.baranov.tdd;

public class Dollar extends Money {

    Dollar(final int amount, final String currency) {
        super(amount, currency);
    }

    public Money times(final int multiplier) {
        return Money.dollar(amount * multiplier);
    }
}

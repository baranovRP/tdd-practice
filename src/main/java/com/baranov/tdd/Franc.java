package com.baranov.tdd;

public class Franc extends Money {

    public Franc(final int amount) {
        this.amount = amount;
    }

    public Money times(final int multiplier) {
        return new Franc(amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    public Franc setAmount(final int amount) {
        this.amount = amount;
        return this;
    }
}

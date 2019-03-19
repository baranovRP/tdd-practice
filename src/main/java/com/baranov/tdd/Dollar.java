package com.baranov.tdd;

public class Dollar extends Money{

    public Dollar(final int amount) {
        this.amount = amount;
    }

    public Money times(final int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    public Dollar setAmount(final int amount) {
        this.amount = amount;
        return this;
    }
}

package com.baranov.tdd;

public class Money {

    protected int amount;

    public boolean equals(final Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}

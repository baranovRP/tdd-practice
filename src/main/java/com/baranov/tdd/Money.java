package com.baranov.tdd;

public abstract class Money {

    protected int amount;

    public static Money dollar(final int amount) {
        return new Dollar(amount);
    }

    public static Money franc(final int amount) {
        return new Franc(amount);
    }

    abstract Money times(final int multiplier);

    public boolean equals(final Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}

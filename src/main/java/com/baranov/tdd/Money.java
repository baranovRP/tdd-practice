package com.baranov.tdd;

public abstract class Money {

    protected int amount;
    protected String currency;

    public Money(final int amount, final String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(final int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(final int amount) {
        return new Franc(amount, "CHF");
    }

    abstract Money times(final int multiplier);

    String currency() {
        return currency;
    }

    public boolean equals(final Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}

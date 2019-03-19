package com.baranov.tdd;

import java.util.StringJoiner;

public class Money {

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

    Money times(final int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    String currency() {
        return currency;
    }

    @Override
    public boolean equals(final Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && currency.equalsIgnoreCase(money.currency());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("amount = " + amount)
                .add("currency = " + currency)
                .toString();
    }
}

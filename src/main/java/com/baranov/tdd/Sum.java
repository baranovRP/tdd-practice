package com.baranov.tdd;

class Sum implements Expression {

    Expression augend;
    Expression addend;

    Sum(final Expression augend, final Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(final Bank bank, final String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(final Expression tenFrancs) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(final int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}

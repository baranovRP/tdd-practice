package com.baranov.tdd;

class Sum implements Expression {

    Money augend;
    Money addend;

    Sum(final Money augend, final Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(final String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}

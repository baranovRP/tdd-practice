package com.baranov.tdd;

public interface Expression {

    Money reduce(Bank bank, String to);
}

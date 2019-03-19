package com.baranov.tdd;

class Bank {

    Money reduce(final Expression source, final String to) {
        return source.reduce(to);
    }
}

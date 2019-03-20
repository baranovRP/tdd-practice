package com.baranov.tdd;

import java.util.Hashtable;
import java.util.Objects;

class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable<>();

    Money reduce(final Expression source, final String to) {
        return source.reduce(this, to);
    }

    int rate(final String from, final String to) {
        if (from.equalsIgnoreCase(to)) {
            return 1;
        }
        return rates.get(new Pair(from, to));
    }

    void addRate(final String from, final String to, final int rate) {
        rates.put(new Pair(from, to), rate);
    }

    private class Pair {

        private String from;
        private String to;

        Pair(final String from, final String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair that = (Pair) o;

            return Objects.equals(this.from, that.from) &&
                    Objects.equals(this.to, that.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}
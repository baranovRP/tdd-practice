package com.baranov.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrancTest {

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.franc(5), Money.franc(6));
        assertNotEquals(Money.franc(5), Money.dollar(5));
    }
}
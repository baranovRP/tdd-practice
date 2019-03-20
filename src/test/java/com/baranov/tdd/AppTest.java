package com.baranov.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String USD = "USD";
    private static final String CHF = "CHF";
    private Money fiveBucks;
    private Money tenFrancs;
    private Bank bank;

    @Before
    public void setUp() {
        fiveBucks = Money.dollar(5);
        tenFrancs = Money.franc(10);
        bank = new Bank();
        bank.addRate(CHF, USD, 2);
    }

    @Test
    public void testMultiplication() {
        assertEquals(Money.dollar(10), fiveBucks.times(2));
        assertEquals(Money.dollar(15), fiveBucks.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(fiveBucks, fiveBucks);
        assertNotEquals(fiveBucks, Money.dollar(6));
        assertNotEquals(Money.franc(5), fiveBucks);
    }

    @Test
    public void testCurrency() {
        assertEquals(USD, Money.dollar(1).currency());
        assertEquals(CHF, Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Expression result = fiveBucks.plus(fiveBucks);
        Sum sum = (Sum) result;
        assertEquals(fiveBucks, sum.augend);
        assertEquals(fiveBucks, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Money result = bank.reduce(sum, USD);
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Money result = bank.reduce(Money.dollar(1), USD);
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Money result = bank.reduce(Money.franc(2), USD);
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate(USD, USD));
    }

    @Test
    public void testMixedAddition() {
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), USD);
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, USD);
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, USD);
        assertEquals(Money.dollar(20), result);
    }
}

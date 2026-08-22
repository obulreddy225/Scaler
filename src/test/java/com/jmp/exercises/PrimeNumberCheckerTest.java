package com.jmp.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PrimeNumberCheckerTest {
    private final PrimeNumberChecker checker = new PrimeNumberChecker();

    @Test
    void shouldReturnTrueForTwo() {
        assertTrue(checker.isPrime(2));
    }

    @Test
    void shouldReturnTrueForThree() {
        assertTrue(checker.isPrime(3));
    }

    @Test
    void shouldReturnTrueForFive() {
        assertTrue(checker.isPrime(5));
    }

    @Test
    void shouldReturnFalseForOne() {
        assertFalse(checker.isPrime(1));
    }

    @Test
    void shouldReturnFalseForNegativeOne() {
        assertFalse(checker.isPrime(-1));
    }

    @Test
    void shouldReturnFalseForZero() {
        assertFalse(checker.isPrime(0));
    }

    @Test
    void shouldReturnFalseForCompositeNumber() {
        assertFalse(checker.isPrime(4));
    }

    @Test
    void shouldReturnFalseForAnotherCompositeNumber() {
        assertFalse(checker.isPrime(9));
    }

    @Test
    void shouldReturnTrueForLargerPrime() {
        assertTrue(checker.isPrime(97));
    }
}

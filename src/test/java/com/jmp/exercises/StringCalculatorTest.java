package com.jmp.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void singleNumberReturnsItself() {
        assertEquals(5, calculator.add("5"));
    }

    @Test
    void twoNumbersAreAdded() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void multipleNumbersAreAdded() {
        assertEquals(10, calculator.add("1,2,3,4"));
    }

    @Test
    void newlineCanBeUsedAsDelimiter() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void commaAndNewlineCanBeMixed() {
        assertEquals(10, calculator.add("1,2\n3,4"));
    }
}

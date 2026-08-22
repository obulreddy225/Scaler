package com.jmp.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LeapYearCalculatorTest {
    private final LeapYearCalculator calculator = new LeapYearCalculator();

    @Test
    void shouldReturnTrueForYearDivisibleBy4() {
        assertTrue(calculator.isLeapYear(2024));
    }

    @Test
    void shouldReturnFalseForYearNotDivisibleBy4() {
        assertFalse(calculator.isLeapYear(2023));
    }

    @Test
    void shouldReturnFalseForCenturyYearNotDivisibleBy400() {
        assertFalse(calculator.isLeapYear(1900));
    }

    @Test
    void shouldReturnTrueForCenturyYearDivisibleBy400() {
        assertTrue(calculator.isLeapYear(2000));
    }

    @Test
    void shouldReturnTrueForAnotherLeapYear() {
        assertTrue(calculator.isLeapYear(2020));
    }

    @Test
    void shouldReturnFalseForAnotherNonLeapYear() {
        assertFalse(calculator.isLeapYear(2021));
    }
}

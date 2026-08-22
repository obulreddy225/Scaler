package com.jmp.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testReturnsFizzForMultiplesOf3() {
        assertEquals("Fizz", fizzBuzz.execute(3));
        assertEquals("Fizz", fizzBuzz.execute(6));
        assertEquals("Fizz", fizzBuzz.execute(9));
    }

    @Test
    public void testReturnsBuzzForMultiplesOf5() {
        assertEquals("Buzz", fizzBuzz.execute(5));
        assertEquals("Buzz", fizzBuzz.execute(10));
        assertEquals("Buzz", fizzBuzz.execute(20));
    }

    @Test
    public void testReturnsFizzBuzzForMultiplesOf15() {
        assertEquals("FizzBuzz", fizzBuzz.execute(15));
        assertEquals("FizzBuzz", fizzBuzz.execute(30));
        assertEquals("FizzBuzz", fizzBuzz.execute(45));
    }

    @Test
    public void testReturnsNumberAsStringForNonMultiples() {
        assertEquals("1", fizzBuzz.execute(1));
        assertEquals("2", fizzBuzz.execute(2));
        assertEquals("4", fizzBuzz.execute(4));
        assertEquals("7", fizzBuzz.execute(7));
        assertEquals("11", fizzBuzz.execute(11));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("Buzz", fizzBuzz.execute(25));
        assertEquals("Fizz", fizzBuzz.execute(12));
        assertEquals("FizzBuzz", fizzBuzz.execute(60));
    }
}

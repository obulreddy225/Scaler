package com.jmp.exercises;

import java.util.stream.IntStream;
public class PrimeNumberChecker {
    public boolean isPrime(int number) {
        // Numbers less than 2 are not prime
        if (number < 2) {
            return false;
        }
        // Check whether any number from 2 to sqrt(number) divides the given number
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }
}

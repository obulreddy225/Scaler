package com.jmp.exercises;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        return Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).sum();
    }
}
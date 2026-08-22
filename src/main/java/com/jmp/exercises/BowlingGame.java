package com.jmp.exercises;

public class BowlingGame {

    private final int[] rolls = new int[21];
    private int rollIndex = 0;

    public void roll(int pins) {
        if (pins < 0 || pins > 10) {
            throw new IllegalArgumentException(
                    "Pins must be between 0 and 10"
            );
        }

        rolls[rollIndex++] = pins;
    }

    public int score() {

        int total = 0;
        int index = 0;

        for (int frame = 0; frame < 10; frame++) {

            // Strike
            if (rolls[index] == 10) {
                total += 10
                        + rolls[index + 1]
                        + rolls[index + 2];

                index++;
            }

            // Spare
            else if (rolls[index] + rolls[index + 1] == 10) {
                total += 10 + rolls[index + 2];

                index += 2;
            }

            // Open frame
            else {
                total += rolls[index]
                        + rolls[index + 1];

                index += 2;
            }
        }

        return total;
    }
}


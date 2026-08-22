package com.jmp.dsa.binarySearch;

public class Koko {
    public static int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;

        // Find maximum pile
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        // Try every possible speed
        for (int speed = 1; speed <= maxPile; speed++) {

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + speed - 1) / speed;
            }

            // If Koko can finish within h hours
            if (hours <= h) {
                return speed;
            }
        }

        return -1;
    }

    public static int minEatingSpeedOptimized(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {

            int speed = left + (right - left) / 2;

            long hours = 0;

            // Calculate hours needed at this speed
            for (int pile : piles) {
                hours += (pile + speed - 1) / speed;
            }

            if (hours <= h) {
                // This speed works.
                // Try a smaller speed.
                right = speed - 1;
            } else {
                // This speed is too slow.
                // Need a bigger speed.
                left = speed + 1;
            }
        }

        return left;
    }
}

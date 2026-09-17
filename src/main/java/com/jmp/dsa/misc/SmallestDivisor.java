package com.jmp.dsa.misc;

public class SmallestDivisor {

    public static int smallestDivisor(int[] nums, int threshold) {

        int max = 0;

        // Find maximum element
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Try every possible divisor
        for (int divisor = 1; divisor <= max; divisor++) {

            long sum = 0;

            // Divide every element by divisor
            for (int i = 0; i < nums.length; i++) {

                // Ceiling division
                sum += (nums[i] + divisor - 1) / divisor;
            }

            // First valid divisor is the smallest divisor
            if (sum <= threshold) {
                return divisor;
            }
        }

        return -1;
    }


    public static int smallestDivisorOptimized(int[] nums, int threshold) {

        int left = 1;
        int right = 0;

        // Maximum possible divisor
        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left <= right) {

            int divisor = left + (right - left) / 2;

            long sum = 0;

            // Calculate sum for this divisor
            for (int num : nums) {
                sum += (num + divisor - 1) / divisor;
            }

            if (sum <= threshold) {
                // Valid divisor.
                // Try to find a smaller one.
                right = divisor - 1;
            } else {
                // Sum is too large.
                // Need a larger divisor.
                left = divisor + 1;
            }
        }

        return left;
    }




}

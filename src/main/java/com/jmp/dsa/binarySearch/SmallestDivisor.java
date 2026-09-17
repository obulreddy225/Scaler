package com.jmp.dsa.binarySearch;

public class SmallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long sum = 0;

            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }

            if (sum <= threshold) {
                // mid works
                // Search for a smaller answer
                right = mid - 1;
            } else {
                // mid doesn't work
                // Need a bigger divisor
                left = mid + 1;
            }


        }

        return left;
    }
}
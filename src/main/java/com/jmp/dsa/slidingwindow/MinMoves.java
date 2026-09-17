package com.jmp.dsa.slidingwindow;

public class MinMoves {
    public static int minMoves(int[] arr) {

        // Count total number of 1s
        int ones = 0;

        for (int num : arr) {
            if (num == 1) {
                ones++;
            }
        }
        // Window size = number of 1s
        int windowOnes = 0;

        // First window
        for (int i = 0; i < ones; i++) {
            if (arr[i] == 1) {
                windowOnes++;
            }
        }

        int maxOnes = windowOnes;

        // Sliding window
        for (int right = ones; right < arr.length; right++) {

            if (arr[right] == 1) {
                windowOnes++;
            }

            if (arr[right - ones] == 1) {
                windowOnes--;
            }

            maxOnes = Math.max(maxOnes, windowOnes);
        }

        return ones - maxOnes;
    }
}

package com.jmp.dsa.scaler.scaler6;

public class SingleNumber {
    public static int singleNumber(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return arr[i];
            }
        }

        return -1;
    }


    public static int singleNumberOptimized(int[] arr) {

        int result = 0;

        // Check every bit position
        for (int i = 0; i < 32; i++) {

            int count = 0;

            // Count how many numbers have 1 at this bit
            for (int num : arr) {

                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // Remove groups of 3
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

    public static int[] findTwoUnique(int[] arr) {

        int xor = 0;

        // Step 1: XOR all elements
        for (int num : arr) {
            xor ^= num;
        }

        // Step 2: Find the rightmost set bit
        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        // Step 3: Divide elements into two groups
        for (int num : arr) {

            if ((num & bit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}

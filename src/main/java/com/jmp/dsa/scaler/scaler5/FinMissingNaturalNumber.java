package com.jmp.dsa.scaler.scaler5;

import java.util.Arrays;
import java.util.HashSet;

public class FinMissingNaturalNumber {

    public static int firstMissingNaturalNumber(int[] arr) {
        int n = arr.length;

        for (int num = 1; num <= n; num++) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (arr[i] == num) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return num;
            }
        }

        return n + 1;
    }

    public static int firstMissingNaturalNumberUsingHashSet(int[] arr) {
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();

        // Store all elements
        for (int num : arr) {
            set.add(num);
        }

        // Check natural numbers from 1 to N
        for (int num = 1; num <= n; num++) {
            if (!set.contains(num)) {
                return num;
            }
        }

        return n + 1;
    }

    public static int firstMissingNaturalNumberUsingSort(int[] arr) {
        Arrays.sort(arr);

        int expected = 1;

        for (int num : arr) {
            if (num == expected) {
                expected++;
            } else if (num > expected) {
                return expected;
            }
        }

        return expected;
    }

    //optimized-------------------------------prefered

    //Cyclic Sort / Index Placement
    //
    //You can reuse the same idea for problems involving:
    //
    //Find missing number
    //Find duplicate number
    //Find all missing numbers
    //Find all duplicates
    //First missing positive
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            while (arr[i] >= 1 &&
                    arr[i] <= n &&
                    arr[i] != i + 1) {

                int val = arr[i];

                // Duplicate found
                if (arr[val - 1] == val) {
                    return val;
                }

                int temp = arr[i];
                arr[i] = arr[val - 1];
                arr[val - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }


}

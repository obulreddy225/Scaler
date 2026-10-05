package com.jmp.dsa.scaler.scaler5;

public class FindDuplicate {
    public static int findDuplicate(int[] arr) {
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

                // Put val at its correct position
                int temp = arr[i];
                arr[i] = arr[val - 1];
                arr[val - 1] = temp;
            }
        }

        return -1;
    }
}

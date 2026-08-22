package com.jmp.dsa.binarySearch;

public class MissingNumber {
    public static int missingNumber(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return left + 1;
    }
}

package com.jmp.dsa.binarySearch;

public class FindNearest {
    public static int findNearest(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // left = first value greater than target
        // right = last value smaller than target

        if (right < 0) {
            return arr[left];
        }

        if (left >= arr.length) {
            return arr[right];
        }

        if (target - arr[right] <= arr[left] - target) {
            return arr[right];
        }

        return arr[left];
    }
}

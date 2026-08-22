package com.jmp.dsa;

public class BinarySearch {
    public static int findMissingNumber(int[] arr, int n) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == mid + 1) {
                // Everything is correct up to mid
                left = mid + 1;
            } else {
                // Missing number is at or before mid
                right = mid - 1;
            }
        }

        return left + 1;
    }



    public static int missingNumber(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } else right = right - 1;
        }
        return left + 1;
    }
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies inside the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // Target must be in right half
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                // Target lies inside the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // Target must be in left half
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

}

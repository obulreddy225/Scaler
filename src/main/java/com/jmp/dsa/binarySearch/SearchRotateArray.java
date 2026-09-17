package com.jmp.dsa.binarySearch;

public class SearchRotateArray {
    class Solution {

        public int search(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                // 1. Target found
                if (nums[mid] == target) {
                    return mid;
                }

                // 2. Left half is sorted
                if (nums[left] < nums[mid]) {

                    // Target is in the left half
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                }
                // 3. Right half is sorted
                else {

                    // Target is in the right half
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return -1;
        }
    }

}

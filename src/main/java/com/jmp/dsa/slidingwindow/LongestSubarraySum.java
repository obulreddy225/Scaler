package com.jmp.dsa.slidingwindow;

public class LongestSubarraySum {
    //Given an array of positive integer nums and an integer k, find the length of the longest
    // subarray whose sum is less than or equal to k
    //e.g: nums = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8

    public static int longestSubarraySum(int[] nums, int k) {

        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand window
            sum += nums[right];

            // Shrink window if sum exceeds k
            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // Current window is valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


}

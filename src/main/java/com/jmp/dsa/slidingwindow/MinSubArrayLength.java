package com.jmp.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class MinSubArrayLength {
    //Given an array of positive integers nums and a positive integer target,
    // return the minimal length of a subarray whose sum is greater than or equal to target.
    // If there is no such subarray, return 0 instead.

    public static int minSubArrayLength(int[] arr, int target) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum-=arr[left];
                left++;
            }
        }

        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    //Given an array of positive integers arr and a positive integer target,
    //find the maximum length of a contiguous subarray whose sum is less than or equal to target.
    //If no such subarray exists, return 0.
    public static int maxSubArrayLength(int[] arr, int target) {

        int left = 0;
        int sum = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int uniqueSubString(String str){
        int left =0;
        int maxLength =0;
        Set<Character> set = new HashSet<>();

        for(int right =0;right<str.length();right++){
            while (set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            maxLength = Math.max(right-left+1,maxLength);
        }

        return maxLength;
    }

}

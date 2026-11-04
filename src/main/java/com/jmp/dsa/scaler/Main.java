package com.jmp.dsa.scaler;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    //Given an integer array nums and an integer target, return the indices of
    // the two numbers whose sum equals the target.
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int needed = target - arr[i];
            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    //find largest element in an array
    public static int largestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    //find missing element
    public static int missingElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    //maximumSumof SubArraySum
    public static int maxSumOfSubArray(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    //best time to sell and buy stock
    public static int maxProfit(int[] arr){
        int minPrice=arr[0];
        int maxProfit =0;
        for (int i=0;i<arr.length;i++){
            minPrice = Math.min(minPrice,arr[i]);
            int profit = arr[i]-minPrice;
            maxProfit =Math.max(profit,maxProfit);
        }
        return maxProfit;
    }

}





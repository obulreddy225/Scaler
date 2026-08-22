package com.jmp.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class longestSubarray {
    public static int longestSubarray(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element to the window
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // More than k distinct elements → shrink window
            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            // Current window is valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println(longestSubarray(nums, k));
    }
}

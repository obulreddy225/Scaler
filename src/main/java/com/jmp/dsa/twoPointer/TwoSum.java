package com.jmp.dsa.twoPointer;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] sum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // [2,7,7,14] , target = 9

        while (left < right) {
            int sum = arr[right] + arr[left];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else left++;
        }
        return new int[]{-1, -1};
    }

    public static int[] sumIfArrayIsNotSorted(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int needed = target-arr[i];
            if(map.containsKey(needed)){
                return new int[]{map.get(needed),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
    }
}

package com.jmp.dsa.twoPointer;

public class TrappingWater {
    public static int trappingRainWaterBruteForce(int[] height) {

        int n = height.length;
        int totalWater = 0;

        //{4,6,3,5,4,7}

        for (int i = 0; i < n; i++) {

            int leftMax = height[i];
            int rightMax = height[i];

            // Find maximum on left
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find maximum on right
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int water = Math.min(leftMax, rightMax) - height[i];

            totalWater += water;
        }

        return totalWater;
    }

    public static int trappingRainWaterOptimized(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }

}

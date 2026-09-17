package com.jmp.dsa.binarySearch;

public class FindMedianSortedArrays {

    public static void main(String[] args){
        int[] arr1 = {1,3};
        int[] arr2 = {2,4};

        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int totalLeft = (m + n + 1) / 2;

        while (left <= right) {

            int partitionA = left + (right - left) / 2;
            int partitionB = totalLeft - partitionA;

            // Boundary values
            int leftA  = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int rightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            int leftB  = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int rightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            // Correct partition
            if (leftA <= rightB && leftB <= rightA) {

                if ((m + n) % 2 == 1) {
                    return Math.max(leftA, leftB);
                } else {
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB)) / 2.0;
                }
            }

            // Took too many elements from nums1
            if (leftA > rightB) {
                right = partitionA - 1;
            }
            // Took too few elements from nums1
            else {
                left = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Arrays are not sorted");
    }
}

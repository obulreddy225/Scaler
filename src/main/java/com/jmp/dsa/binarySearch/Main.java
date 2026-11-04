package com.jmp.dsa.binarySearch;

import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) {

    }

    //Find the missing number in a sorted array containing numbers from 1 to N
    public static int missingNumber(int[] arr) {
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

    public static int peakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public static int cocoEatingBananas(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int num : piles) {
            right = Math.max(num, right);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int smallestDivisor(int[] arr, int max) {
        int left = 1;
        int right = 0;
        for (int num : arr) {
            right = Math.max(right, num);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int divisor = 0;
            for (int num : arr) {
                divisor += (num + mid - 1) / mid;
            }
            if (divisor <= max) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return left;
    }

    // Find the Index Where an Element Should Be Inserted
    //   You are given a sorted array of distinct integers and a target value X.
    //   If X exists in the array, return its index.
    //   If it does not exist, return the index where it should be inserted to maintain sorted order.
    //   The solution must use Binary Search
    public static int insertPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]<target) {
                left = mid+1;
            }else right =mid-1;
        }
        return left;
    }

    //Find the First Occurrence of a Number Using Binary Search
    //You are given a sorted array of integers that may contain duplicate values and a target number X.
    //Find the index of the first occurrence of X using Binary Search.
    //If the element is not present, return -1
    public static int firstPosition(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int answer =-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                answer = mid;
                right = mid-1;
            } else if (arr[mid]<target) {
                left = mid+1;
            }else right =mid-1;
        }
        return answer;
    }

    //Find the Last Occurrence of a Number
    public static int lastPosition(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int answer =-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                answer = mid;
                left  = mid+1;
            } else if (arr[mid]<target) {
                left = mid+1;
            }else right =mid-1;
        }
        return answer;
    }


    public static int searchRotated(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise, the right half is sorted
            else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }


}

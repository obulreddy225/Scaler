package com.jmp.dsa.twoPointer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTwoPointer {
    //Reverse string without changiacng position of special char
    //s = "ab#cd,e@f" output= fe#dc,b@a
    public static String reverseString(String str) {
        str = str.toLowerCase();
        char[] arr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;


        while (left < right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }


    public static int[] sum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else left++;
        }
        return new int[]{-1, -1};
    }

//    Valid Palindrome
//
//    Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//    A palindrome is a string that reads the same forward and backward.
//
//    Examples
//    Input:
//    s = "A man, a plan, a canal: Panama"
//
//
//    Output:
//            true

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            } else {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    //3Sum
    public static List<List<Integer>> ThreeSum(int[] arr) {
        List<List<Integer>> triplet = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > 0) {
                break;
            }
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    triplet.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else left++;
            }
        }
        return triplet;
    }

    //Container With Most Water
    public static int containerWithMostWater(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int height = Math.min(arr[left], arr[right]);

            int area = width * height;

            maxArea = Math.max(maxArea, area);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int[] moveZerosToEnd(int[] arr) {
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        return arr;
    }

    public static int[] moveZerosToStart(int[] arr) {
        int left = arr.length - 1;
        for (int right = arr.length - 1; right >= 0; right--) {
            if (arr[right] != 0) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left--;
            }
        }
        return arr;
    }

    //Sort Colors
    public static int[] sortColours(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            }else {
                int temp =arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        return arr;
    }

    public static int trappinWater(int[] arr){
        int left =0;
        int right =arr.length-1;

        int leftMax =0;
        int rightMax =0;
        int totalWater =0;

        while (left<=right){
            if(arr[left]<arr[right]){
                if(arr[left]>leftMax){
                    leftMax =arr[left];
                }else
                    totalWater +=leftMax-arr[left];

                left++;
            }else {
                if(arr[right]>rightMax){
                    rightMax =arr[right];
                }else
                    totalWater +=rightMax-arr[right];

                right--;
            }
        }
        return totalWater;
    }


public static void main(String[] args) {


}
}


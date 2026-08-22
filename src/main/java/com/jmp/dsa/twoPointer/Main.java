
package com.jmp.dsa.twoPointer;

import javax.security.auth.callback.CallbackHandler;
import java.lang.management.ManagementFactory;
import java.util.*;

public class Main {
    //Reverse string without changiacng position of special char
    //s = "ab#cd,e@f" output= fe#dc,b@a
    public static String revString(String str){
        char[] arr = str.toCharArray();
        int left =0;
        int right = arr.length-1;
        while (left<right){
            if(!Character.isLetterOrDigit(arr[left])){
                left++;
            }else if(!Character.isLetterOrDigit(arr[right])){
                right--;
            }else {
                char temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;

            }
        }
        return new String(arr);
    }

    //Two Sum II - Input Array Is not Sorted
    public static int[] sum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length-1;i++){
            int needed = target-arr[i];
            if(map.containsKey(needed)){
                return new int[] {map.get(needed),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {-1,-1};
    }

    //Two Sum II - Input Array Is not Sorted
    public static int[] sumTwo(int[] arr, int target){
        int left =0;
        int right =arr.length-1;
        while (left<right){
            int sum =arr[left]+arr[right];
            if(sum==target){
                return new int[] {left,right};
            } else if (sum>target) {
                right=right-1;
            }else {
                left=left+1;
            }
        }
        return new int[] {-1,-1};
    }

    //Valid Palindrome
    //
    //Given a string s, return true if it is a palindrome, or false otherwise.
    //
    //A string is considered a palindrome if, after converting all uppercase letters to lowercase and removing
    // all non-alphanumeric characters, it reads the same forward and backward.
    //Alphanumeric characters include letters (a-z, A-Z) and digits (0-9).
    //Example 1
    //Input:
    //s = "A man, a plan, a canal: Panama"
    //Output:
    //true
    public static boolean isValidPalindrome(String str){
        str=str.toLowerCase();
        int left =0;
        int right = str.length()-1;
        while (left<right){
            if(!Character.isLetterOrDigit(str.charAt(left))){
                left++;
            } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }else {
                if(str.charAt(left)!=str.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static List<List<Integer>> ThreeSum(int[] arr){
        List<List<Integer>> triplet = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i>0&&arr[i-1]==arr[i]){
                continue;
            }
            if(arr[i]>0){
                break;
            }

            int left = i+1;
            int right = arr.length-1;
            while (left<right){
                int sum =arr[i]+arr[left]+arr[right];
                if (sum==0){
                    triplet.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    while (left<right&&arr[left]==arr[left+1]){
                        left++;
                    }
                    while (left<right&&arr[right]==arr[right-1]){
                        right--;
                    }
                    left++;
                    right--;

                }else if (sum>0){
                    right--;
                }else left++;
            }
        }
        return triplet;
    }
    //Container With Most Water
    public static int containerWater(int[] arr){
        int left =0;
        int right =arr.length-1;
        int width = right-left;
        int height= Math.min(arr[left],arr[right]);
        int area = width*height;
        int maxArea = 0;
        while (left<right){
            maxArea =Math.max(area,maxArea);
            if(arr[left]<arr[right]){
                left++;
            }else right--;
        }
        return maxArea;
    }



    public static void main(String[] args){

    }
}

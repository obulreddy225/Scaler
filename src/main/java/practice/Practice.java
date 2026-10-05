package practice;

import com.jmp.dsa.scaler.scaler6.CheckSet;

import java.util.*;

public class Practice {
    public int[] twoSum(int[] arr, int target) {
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

    public int largestElementInArray(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public int missingNumber(int[] arr) {
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

    public int maxSumOfSubArray(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    //interview safe version
//    public int maxSumOfSubArray(int[] arr) {
//        int currentSum = arr[0];
//        int maxSum = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {
//            currentSum = Math.max(arr[i], currentSum + arr[i]);
//            maxSum = Math.max(currentSum, maxSum);
//        }
//
//        return maxSum;
//    }

    public int maxProfit(int[] prices) {
        int minPrice = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(profit, maxProfit);

        }
        return minPrice;
    }

    public int maxSumOfSubArrayOfLengthK(int[] arr, int k) {
        int windowSum = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        int si = 1;
        int ei = k;
        while (ei < n) {
            windowSum = windowSum - arr[si - 1] + arr[ei];
            maxSum = Math.max(windowSum, maxSum);
            si++;
            ei++;
        }
        return maxSum;
    }

    public boolean haveDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean validParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == '}' && top != '{') ||
                        (ch == ']' && top != '[') ||
                        (ch == ')' && top != '(')) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    public static void moveZerosToEnd(int[] arr) {
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
    }

    public static void moveZerosToStart(int[] arr) {
        int right = arr.length - 1;
        for (int left = arr.length - 1; left >= 0; left--) {
            if (arr[left] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            }
        }
    }

    public static int removeDuplicatesFromSortedArray(int[] arr) {
        int left = 0;
        for (int right = 1; right < arr.length; right++) {
            if (arr[right] != arr[left]) {
                left++;
                arr[left] = arr[right];
            }
        }
        return left + 1;
    }

    public static int[] rotateArrayToRightByK(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        rotateSubArray(arr,0,n-1);
        rotateSubArray(arr,0,k-1);
        rotateSubArray(arr,k,n-1);
        return arr;

    }

    public int[]  rotateArrayToLeftByK(int[] arr, int k){
        int n =arr.length;
        k=k%n;
        rotateSubArray(arr,0,k-1);
        rotateSubArray(arr,k,n-1);
        rotateSubArray(arr,0,n-1);

        return arr;
    }

    public static int[] rotateSubArray(int[] arr, int left, int right){
        while (left<right){
            int temp =arr[right];
            arr[right]=arr[left];
            arr[left]=temp;
            left++;
            right--;
        }

        return arr;
    }

    public int maxProfitII(int[] arr) {
        int totalProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                totalProfit = totalProfit + (arr[i] - arr[i - 1]);
            }
        }

        return totalProfit;
    }

    public static int[] mergeSortedArray(int[] arr1, int[] arr2){
        int m =arr1.length;
        int n = arr2.length;
        int[] result = new int[m+n];

        int i=0;
        int j=0;
        int k=0;
        while (i<m&&j<n){
            if(arr1[i]<arr2[j]){
                result[k++]=arr1[i++];
            }else {
                result[k++]=arr2[j++];
            }
        }

        while (i<m){
            result[k++]=arr1[i++];
        }
        while (j<n){
            result[k++]=arr2[j++];
        }
        return result;
    }

    public static int subStringWithOutRepeatingCharacters(String str){
        int left =0;
        Set<Character> set = new HashSet<>();
        int maxLength =0;
        for (int right =0;right<str.length();right++){
            char ch =str.charAt(right);
            while (set.contains(ch)){
               set.remove(str.charAt(left));
               left++;
            }
            set.add(ch);
            maxLength= Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    public static String subStringWithOutRepeatingCharactersString(String str){
        int left =0;
        Set<Character> set = new HashSet<>();
        int maxLength =0;
        int start = 0;
        for (int right =0;right<str.length();right++){
            char ch =str.charAt(right);
            while (set.contains(ch)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);
            if(right-left+1>maxLength){
                maxLength=right-left+1;
                start = left;
            }
        }
        return str.substring(start,start+maxLength);
    }



}

package com.jmp.dsa.slidingwindow;

public class Main {
    //LongestUniformString
   public static void uniformString(String str){
       int currentLength = 1;
       int currentStart = 0;

       int maxLength = 1;
       int maxStart = 0;
       for(int i=1;i<str.length();i++){
           if (str.charAt(i)==str.charAt(i-1)){
               currentLength++;
           }else {
               currentStart=i;
               currentLength =1;
           }
           if(currentLength>maxLength){
               maxLength = currentLength;
               maxStart = currentStart;
           }
       }
   }

    //Find the sum of minimum and maximum element of all subarrays of size K

    public static int sumMinMax(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            return 0;
        }

        int totalSum = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            int min = arr[i];
            int max = arr[i];

            for (int j = i; j < i + k; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
            }

            totalSum += min + max;
        }

        return totalSum;
    }
}

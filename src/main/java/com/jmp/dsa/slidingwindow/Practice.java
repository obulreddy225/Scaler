package com.jmp.dsa.slidingwindow;

public class Practice {

    public static int sumMinMax(int[] arr, int k) {
        int totalSum =0;


        for (int i=0;i<=arr.length-k;i++){
            int min = arr[i];
            int max = arr[i];

            for (int j=i;j<=i+k;j++){
                min = Math.min(min,arr[j]);
                max = Math.max(max,arr[j]);
            }
            totalSum+=min+max;
        }
        return totalSum;
    }
    //Sliding window Longest Repeating Substring
    public static String longestRepeatingSubString(String str){
        int currentStart =0;
        int currentLength = 1;

        int maxStart = 0;
        int maxLength = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                currentLength++;
            }else {
                currentLength = 1;
                currentStart = i;
            }
            if(currentLength>maxLength){
                maxLength =currentLength;
                maxStart =currentStart;
            }
        }

        return str.substring(maxStart,maxStart+maxLength);
    }
}

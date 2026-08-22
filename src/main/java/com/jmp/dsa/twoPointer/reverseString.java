package com.jmp.dsa.twoPointer;

public class reverseString {
    //Reverse string without changing position of special char
    //s = "ab#cd,e@f" output= fe#dc,b@a
    public static String reveString(String str){
        char[] arr = str.toCharArray();
        int left =0;
        int right = arr.length-1;
        while (left<right){
            if(!Character.isLetterOrDigit(arr[left])){
                left++;
            } else if (!Character.isLetterOrDigit(arr[right])) {
                right--;
            }else {
                char temp =arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {

    }
}

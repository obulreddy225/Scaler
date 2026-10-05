package com.jmp.dsa.scaler.scaler0;

public class FindUnique {

    public static void main(String[] args){
        System.out.println(findUnique(new int[] {1,3,1,4,3}));
    }
    //"Every element twice + one unique → XOR cancels duplicates."
    public static int findUnique(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result = result ^ num;
        }

        return result;
    }
}

package com.jmp.dsa;


import java.util.Arrays;




public class Main {
    public static void main(String[] args) {
        System.out.println(countFactors(24));
    }

    public static int countFactors(int n){
        int count =0;
        for(int i=1;i*i<=n;i++) {
            if(n%i==i){
                count++;
            }else {
                count+=2;
            }

        }
        return count;
    }



}

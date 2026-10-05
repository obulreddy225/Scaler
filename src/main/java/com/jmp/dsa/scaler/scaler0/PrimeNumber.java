package com.jmp.dsa.scaler.scaler0;

public class PrimeNumber {
    //countFactors
    public static int factorCount(int num){
        int count =0;
        for (int i=1;i*i<=num;i++){
            if(num%i==0){
               if(i==num/i){
                   count++;
               }else {
                   count+=2;
               }
            }
        }
        return count;
    }

}

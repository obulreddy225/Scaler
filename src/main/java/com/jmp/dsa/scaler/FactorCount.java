package com.jmp.dsa.scaler;

public class FactorCount {
    public static int countFactors(int num){
        int factorCount = 0;

        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                if(i==num/i){
                    factorCount++;
                }else factorCount+=2;
            }
        }
        return factorCount;
    }

    public static void main(String[] args){
        System.out.println(countFactors(4));
    }
}

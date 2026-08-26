package com.jmp.dsa.scaler.scaler1;

public class Factors {
    public static int countFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countFactorsOptimized(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
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

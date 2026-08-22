package com.jmp.dsa;

public class CountFactors {
    public static int countFactors(int num){
        int count =0;
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                if(i==num/i){
                    count+=1;
                }else count+=2;
            }
        }
        if(count==2){
            //it's prime number
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(countFactors(100));
        System.out.println(countFactors(25));
        System.out.println(countFactors(5));


    }
}

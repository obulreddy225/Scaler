package com.jmp.dsa.scaler.scaler1;

public class SumOfAllSubArraySum {

    public static int sumOfAllSubArraySum(int[] arr){
        int n =arr.length;
        int answer =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum =0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                answer+=sum;
            }
        }
        return answer;
    }

    //carryForward
    public static int sumOfAllSubArraySumCarrayForward(int[] arr){
        int answer =0;
        for(int i=0;i<arr.length;i++){
            int sum =0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                answer+=sum;
            }
        }
        return answer;
    }

    public static int sumOfAllSubArraySumOptimized(int[] arr){
        int answer =0;
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            answer +=arr[i]*(i+1)*(n-i);
        }
        return answer;
    }
}

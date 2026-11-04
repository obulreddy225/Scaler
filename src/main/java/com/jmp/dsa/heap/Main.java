package com.jmp.dsa.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    //Kth smallest Element int the array
    public static int kthSmallestElement(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:arr){
            pq.offer(num);
        }
        for (int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }
    // TOp K frequent elements in an array
    public static int[] kFrequentElementsInArray(int[] arr,int k){
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num:arr){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(a.getValue(),b.getValue()));

        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.poll().getKey();
        }

        return result;
    }

    }

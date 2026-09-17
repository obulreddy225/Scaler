package com.jmp.dsa.misc;

import java.util.Random;

public class Shuffle {
    public static void shuffle(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            // Generate random index from 0 to i
            int j = random.nextInt(i + 1); //
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }



    public static void shuffle1(int[] arr) {

        Random random = new Random();

        for (int i = 0; i < arr.length - 1; i++) {

            // Generate random index from i to arr.length - 1
            int j = i + random.nextInt(arr.length - i);

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}


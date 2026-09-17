package com.jmp.dsa.arrays;

import java.util.Random;

public class Arrays {

    //This is the Fisher-Yates Shuffle. It runs in O(n) time and uses O(1) extra space.
    public static void shuffleArray(int[] arr) {


        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

package com.jmp.dsa.misc;

import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 0; i < n; i++) {

                // Compare with left neighbor
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    if (candies[i] <= candies[i - 1]) {
                        candies[i] = candies[i - 1] + 1;
                        changed = true;
                    }
                }

                // Compare with right neighbor
                if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                    if (candies[i] <= candies[i + 1]) {
                        candies[i] = candies[i + 1] + 1;
                        changed = true;
                    }
                }
            }
        }

        int total = 0;

        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}

package com.jmp.dsa.misc;

public class LeastInterval {
    public static int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFrequency = 0;

        for (int count : frequency) {
            maxFrequency = Math.max(maxFrequency, count);
        }

        // Number of intervals between the most frequent tasks
        int gaps = maxFrequency - 1;

        // Each gap needs n cooldown intervals
        int emptySlots = gaps * n;

        // Fill the gaps with other tasks
        for (int count : frequency) {
            emptySlots -= Math.min(count, gaps);
        }

        // If empty slots remain, we need idle intervals
        if (emptySlots > 0) {
            return tasks.length + emptySlots;
        }

        return tasks.length;
    }
}

package com.jmp.dsa.nonOverLap;

import java.util.*;

public class maxMeetings {


    public static int maxMeetings(int[][] meetings) {

        // Sort meetings based on end time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1;
        int lastFinish = meetings[0][1];

        // Select non-overlapping meetings
        for (int i = 1; i < meetings.length; i++) {

            if (meetings[i][0] > lastFinish) {
                count++;
                lastFinish = meetings[i][1];
            }
        }

        return count;
    }


}

package practice;

import java.util.*;

public class Practice1 {
    public static int firstMissingPositive(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            while (arr[i] > 0 &&
                    arr[i] <= arr.length &&
                    arr[arr[i] - 1] != arr[i]) {

                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[arr[i] - 1] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }

    public static int findDuplicate(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            while (arr[i] != arr[arr[i] - 1]) {

                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[arr[i] - 1] = temp;
            }

            if (arr[i] != i + 1) {
                return arr[i];
            }
        }

        return -1;
    }

    public static int[][] mergeIntervals(int[][] intervals) {

        // 1. Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // 2. Start with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // 3. Compare with remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlapping
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // Not overlapping
            else {
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }

    //non-overlap
    public static int maxMeetings(int[][] meetings) {

        // Sort meetings by end time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = -1;

        for (int i = 0; i < meetings.length; i++) {

            // Meeting can be selected
            if (meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        return count;
    }

    public static int maxActivities(int[][] activities) {

        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = -1;

        for (int i = 0; i < activities.length; i++) {

            if (activities[i][0] > lastEnd) {
                count++;
                lastEnd = activities[i][1];
            }
        }

        return count;
    }

    public static int[] topKFrequent(int[] arr, int k) {

        // Step 1: Count frequencies
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create Min Heap based on frequency
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // Step 3: Keep only K elements
        for (int num : map.keySet()) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Store result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isCyclic(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }


}

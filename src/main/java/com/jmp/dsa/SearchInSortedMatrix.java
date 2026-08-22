
package com.jmp.dsa;

public class SearchInSortedMatrix {

    public static boolean search(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] < target) {
                row++;
            } else {
                col--;
            }

        }
        return false;
    }


    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int target = 11;
        System.out.println(search(arr, target));

    }
}







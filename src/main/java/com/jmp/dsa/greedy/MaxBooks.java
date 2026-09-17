package com.jmp.dsa.greedy;

import com.jmp.dsa.arrays.Arrays;

import java.util.Collections;

public class MaxBooks {
    public static int maxBooks(int m, int c, int x) {

        // Number of books bought initially
        int booksRead = m / c;

        // These books become used after reading
        int usedBooks = booksRead;

        // x = number of used books required for 1 new book
        while (usedBooks >= x) {

            int newBooks = usedBooks / x;

            // Remaining used books + newly read books
            usedBooks = (usedBooks % x) + newBooks;

            booksRead += newBooks;
        }

        return booksRead;
    }


}

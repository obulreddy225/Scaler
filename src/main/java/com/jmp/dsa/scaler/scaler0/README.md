1. Prime number 
2. unique number if array have only 1 unique
3. even number and odd number program by bitwise operator
4. count number of 1's in binary format
Additional problems
5. We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
   For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

    You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
6. You have an array A with N elements. We have two types of operation available on this array :
   We can split an element B into two elements, C and D, such that B = C + D.
   We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
   You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
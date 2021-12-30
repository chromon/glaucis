/*
1175. Prime Arrangements
Easy

Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: n = 5
Output: 12
Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
Example 2:

Input: n = 100
Output: 682289015
 

Constraints:

1 <= n <= 100
*/

class Solution {
    public int numPrimeArrangements(int n) {
               
        int count = countPrimes(n + 1);
        int notPrimeCount = n - count;
        
        int m = 1000000007;
        long res = 1;
        
        for (int i = 1; i <= count; i++) {
            res = res * i % m;
        }
        
        for (int i = 1; i <= notPrimeCount; i++) {
            res = res * i % m;
        }
        
        return (int) res;        
    }
    
    public int countPrimes(int n) {
        
        boolean[] notPrime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
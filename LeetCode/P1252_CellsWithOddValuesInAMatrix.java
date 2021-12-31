/*
1252. Cells with Odd Values in a Matrix
Easy

There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.

For each location indices[i], do both of the following:

Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

 

Example 1:


Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
Example 2:


Input: m = 2, n = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
 

Constraints:

1 <= m, n <= 50
1 <= indices.length <= 100
0 <= ri < m
0 <= ci < n
 

Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
*/

class Solution {
    
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        
        for (int[] idx : indices) {
            row[idx[0]]++;
            col[idx[1]]++;
        }
        
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += (row[i] + col[j]) % 2;
            }
        }
        
        return res;
    }
    
    /*
    // 又不是不能用.jpg
    public int oddCells(int m, int n, int[][] indices) {
        
        int[][] arr = new int[m][n];
        
        for (int i = 0; i < indices.length; i++) {
            arr = incR(arr, indices[i][0], n);
            arr = incC(arr, indices[i][1], m);
        }
        
        int res = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] % 2 == 1) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public int[][] incR(int[][] arr, int r, int n) {
        for (int i = 0; i < n; i++) {
            arr[r][i]++;
        }
        return arr;
    }
    
    public int[][] incC(int[][] arr, int c, int m) {
        for (int i = 0; i < m; i++) {
            arr[i][c]++;
        }
        return arr;
    }
    */
    
}
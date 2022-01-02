/*
1351. Count Negative Numbers in a Sorted Matrix
Easy

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 

Follow up: Could you find an O(n + m) solution?
*/

class Solution {
    /*
    public int countNegatives(int[][] grid) {
        
        int sum = 0;
        
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    sum++;
                } else {
                    break;
                }
            }
        }
        
        return sum;
    }
    */
    
    public int countNegatives(int[][] grid) {
        int res = 0;
        
        int row = grid.length - 1;
        int col = 0;

        while(col < grid[0].length && row >= 0) {
            if(grid[row][col] < 0) {
                res += grid[0].length - col;
                row--;
            }
            else {
                col++;
            }
        }
        
        return res;
    }
}
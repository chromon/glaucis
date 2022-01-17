/*
1886. Determine Whether Matrix Can Be Obtained By Rotation
Easy

Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

 

Example 1:


Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:


Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 

Constraints:

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.
*/

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        /*
            1 2 3
            o o o
            o o o
            ==
            o o 1
            o o 2
            o o 3
            
            mat[r][c] => mat[c][n - r - 1]
        */
        if (isEqual(mat, target)) {
            return true;
        }
        
        for (int i = 1; i <= 3; i++) {
            mat = rotate(mat);
            if (isEqual(mat, target)) {
                return true;
            }
        }
        
        return false;
    }
    
    private int[][] rotate(int[][] mat) {
        int[][] t = new int[mat.length][mat.length];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                t[j][mat.length - i - 1] = mat[i][j];
            }
        }
        return t;
    }
    
    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
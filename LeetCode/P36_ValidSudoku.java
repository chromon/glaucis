/*
36. Valid Sudoku
Medium

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/

class Solution {
    /*
        可以使用哈希表记录每一行、每一列和每一个小九宫格中，每个数字出现的次数。只需要遍历数独一次，
        在遍历的过程中更新哈希表中的计数，并判断是否满足有效的数独的条件即可。

        对于数独的第 i 行第 j 列的单元格，该单元格所在的行下标和列下标分别为 i 和 j，
        
        创建二维数组 rows 和 cols 分别记录数独的每一行和每一列中的每个数字的出现次数，
        创建三维数组 subs 记录数独的每一个小九宫格中的每个数字的出现次数。
    */
    public boolean isValidSudoku(char[][] board) {
        
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subs = new int[3][3][9];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = c - '0' - 1;

                    rows[i][idx]++;
                    cols[j][idx]++;
                    subs[i / 3][j / 3][idx]++;

                    if (rows[i][idx] > 1 || cols[j][idx] > 1 || subs[i / 3][j / 3][idx] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
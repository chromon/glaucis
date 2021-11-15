/*
52. N-Queens II
Hard

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
*/

class Solution {
    
    int res = 0;
    
    public int totalNQueens(int n) {
        char[][] board = fillBoard(n);
        backtrace(board, 0);
        return res;
    }
    
    // board 中⼩于 row 的⾏都已经成功放置了皇后
    private void backtrace(char[][] board, int row) {
        if (row == board[0].length) {
            res++;
            return;
        }
        
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrace(board, row + 1);
            board[row][col] = '.';
        }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        int n = board[row].length;
        
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // 检查右上⽅是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
                i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上⽅是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
                i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    private char[][] fillBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; 
            }
        }
        return board;
    }
}
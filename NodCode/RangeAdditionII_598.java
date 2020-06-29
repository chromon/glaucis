class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        
        if (ops.length < 1) {
            return m * n;
        }
        
        // 取交集
        int row = m, col = n;
        
        for (int i = 0; i < ops.length; i++) {
            row = Math.min(row, ops[i][0]);
            col = Math.min(col, ops[i][1]);
        }
        
        return row * col;
    }
}
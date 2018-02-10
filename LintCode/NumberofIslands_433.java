public class Solution {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        int count = 0;
        
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                
                if(grid[i][j]) {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(boolean[][] grid, int x, int y) {
        if(! ((x < 0) || (y < 0) || (x >= grid.length) 
            || (y >= grid[0].length) || (!grid[x][y]))) {
            grid[x][y] = false;
            
            dfs(grid, x - 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x + 1, y);
            dfs(grid, x, y + 1);
        }
    }
}
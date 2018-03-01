public class Solution {
    /**
     * @param n: a Integer
     * @return: a spiral array
     */
    public int[][] spiralArray(int n) {
        // write your code here
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, bottom = n - 1, top = 0, num = 1;
        while(left < right && top < bottom) {
            // 添加该圈第一行
            for(int i = left; i < right; i ++) {
                res[top][i] = num ++;
            }
            // 添加最后一列
            for(int i = top; i < bottom; i ++) {
                res[i][right] = num ++;
            }
            // 添加最后一行
            for(int i = right; i > left; i --) {
                res[bottom][i] = num ++;
            }
            // 添加第一列
            for(int i = bottom; i > top; i --) {
                res[i][left] = num ++;
            }
            
            top ++;
            bottom --;
            left ++;
            right --;
        }
        
        // 如果是奇数，加上中间那个点
        if(n % 2 == 1){
            res[n / 2][n / 2] = num;
        }
        
        return res;
    }
}
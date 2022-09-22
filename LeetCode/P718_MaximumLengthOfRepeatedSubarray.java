/*
718. Maximum Length of Repeated Subarray
Medium

Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100
*/

class Solution {
    
    public int findLength(int[] nums1, int[] nums2) {
        
        /*
            设 A 数组为 [1, 2, 3]，B 两数组为为 [1, 2, 4] ，那么在暴力解法中 A[2] 与 B[2] 被比较了三次。
            这三次比较分别是计算 A[0:] 与 B[0:] 最长公共前缀、 A[1:] 与 B[1:] 最长公共前缀以及
            A[2:] 与 B[2:] 最长公共前缀时产生的。
        
            如果 A[i] == B[j]，那么 A[i:] 与 B[j:] 的最长公共前缀为 A[i + 1:] 与 B[j + 1:] 的
            最长公共前缀的长度加一，否则 A[i:] 与 B[j:] 的最长公共前缀为零。

            令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。
            
            如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
        */
        
        int m = nums1.length;
        int n = nums2.length;
        
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = (nums1[i] == nums2[j]) ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
        
    }
    
    /*
    public int findLength(int[] nums1, int[] nums2) {
        
        int res = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int k = 0;
                
                while ((i + k < nums1.length) && (j + k < nums2.length) 
                       && (nums1[i + k] == nums2[j + k])) {
                    k += 1;
                }
                
                res = Math.max(res, k);
            }
        }
        
        return res;
    }
    */
}
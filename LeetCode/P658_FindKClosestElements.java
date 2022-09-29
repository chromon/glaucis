/*
658. Find K Closest Elements
Medium

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // 答案一定是一个连续的窗口；从窗口左右两端依次排除数字，最后留下 k 个数
        
        int left = 0;
        int right = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < arr.length - k; i++) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        
        for (int i = left; i < right + 1; i++) {
            res.add(arr[i]);
        }
        
        return res;
    }
}
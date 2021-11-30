/*
1109. Corporate Flight Bookings
Medium

861

133

Add to List

Share
There are n flights that are labeled from 1 to n.

You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.

Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.

 

Example 1:

Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]
Explanation:
Flight labels:        1   2   3   4   5
Booking 1 reserved:  10  10
Booking 2 reserved:      20  20
Booking 3 reserved:      25  25  25  25
Total seats:         10  55  45  25  25
Hence, answer = [10,55,45,25,25]
Example 2:

Input: bookings = [[1,2,10],[2,2,15]], n = 2
Output: [10,25]
Explanation:
Flight labels:        1   2
Booking 1 reserved:  10  10
Booking 2 reserved:      15
Total seats:         10  25
Hence, answer = [10,25]

 

Constraints:

1 <= n <= 2 * 104
1 <= bookings.length <= 2 * 104
bookings[i].length == 3
1 <= firsti <= lasti <= n
1 <= seatsi <= 104
*/


/*
输入一个长度为 n 的数组 nums，其中所有元素都是 0。
再输入一个 bookings，里面是若干三元组 (i,j,k)，每个三元组的含义是 nums 数组的闭区间 [i-1,j-1] 中所有元素都加上 k。请返回最后的 nums 数组

算法与查分数组一致。
*/
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Diff diff = new Diff(nums);
        for (int i = 0; i < bookings.length; i++) {
            diff.inc(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
        }
        return diff.result();
    }
}

class Diff {
    // 差分数组
    private int[] diff;
    
    // 输入一个初始数组，区间操作将在这个数组上进行
    public Diff(int[] nums) {
        diff = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    
    // 给闭区间 [i, j] 增加 val（可以是负数）
    public void inc(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }
    
    // 返回结果数组
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
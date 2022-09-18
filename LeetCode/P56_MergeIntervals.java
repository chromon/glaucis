/*
56. Merge Intervals
Medium

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        // 按照区间的左端点排序，那么在排完序的列表中，可以合并的区间一定是连续的
        // 将列表中的区间按照左端点升序排序。然后将第一个区间加入 list 中，并按顺序依次考虑之后的每个区间：

        // 1. 如果当前区间的左端点在 list 中最后一个区间的右端点之后，
        //    那么它们不会重合，可以直接将这个区间加入 list 的末尾；

        // 2. 否则，它们重合，需要用当前区间的右端点更新 list 中最后一个区间的右端点，将其置为二者的较大值。

        
        if (intervals.length == 0) {
            return new int[0][2];
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> list = new ArrayList<>();
        
        for (int[] interval: intervals) {
            int left = interval[0];
            int right = interval[1];
            
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }
        
        return list.toArray(new int[list.size() - 1][]);
    }
}
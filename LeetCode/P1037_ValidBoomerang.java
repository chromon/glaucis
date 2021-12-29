/*
1037. Valid Boomerang
Easy

Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.

A boomerang is a set of three points that are all distinct and not in a straight line.

 

Example 1:

Input: points = [[1,1],[2,3],[3,2]]
Output: true
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: false
 

Constraints:

points.length == 3
points[i].length == 2
0 <= xi, yi <= 100
*/

class Solution {
    public boolean isBoomerang(int[][] points) {
        
        // y = kx + b;
        // k = (y1 - y2) / (x1 - x2);
        
        // (y1 - y3) / (x1 - x3) = (y1 - y2) / (x1 - x2);
        // (y1 - y3) * (x1 - x2) = (y1 - y2) * (x1 - x3);
        
        return (points[0][1] - points[2][1]) * (points[0][0] - points[1][0])
            != (points[0][1] - points[1][1]) * (points[0][0] - points[2][0]);
    }
}
/*
1232. Check If It Is a Straight Line
Easy

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        if (coordinates.length < 3) {
            return true;
        }
        
        for (int i = 2; i < coordinates.length; i++) {
            if (!check(coordinates[i - 2], coordinates[i - 1], coordinates[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean check(int[] a, int[] b, int[] c) {
        /*
        y = kx + b;
        b = y - kx;
        
        y1 - kx1 = y2 - kx2;
        k = (y1 - y2) / (x1 - x2);
        
        (y1 - y2) / (x1 - x2) = (y2 - y3) / (x2 - x3);
        (y1 - y2) * (x2 - x3) = (y2 - y3) * (x1 - x2);
        */
        
        return (a[1] - b[1]) * (b[0] - c[0]) == (b[1] - c[1]) * (a[0] - b[0]);
    }
}
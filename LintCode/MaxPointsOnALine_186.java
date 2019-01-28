/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: an array of point
     * @return: An integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if(points == null || points.length == 0){
            return 0;
        }
        int result = 1;
        HashMap<Double , Integer> record = new HashMap<Double , Integer>();
        for(int i = 0; i<points.length;i++){
            int same = 0;
            record.clear();
            record.put((double)Integer.MIN_VALUE , 1);
            for(int j = i+1;j<points.length;j++){
                if(points[j].x == points[i].x && points[j].y == points[i].y){
                    same++;
                    continue;
                }
                double k = 0;
                if(points[j] == points[i]){
                    k = (double)Integer.MAX_VALUE;
                }else{
                    k = (double)(points[j].y - points[i].y)/(double)(points[j].x - points[i].x);
                }
                if(record.containsKey(k)){
                    record.put(k , record.get(k) + 1);
                }else{
                    record.put(k , 2);
                }
            }
            for(int count : record.values()){
                if(count + same > result){
                    result = count + same;
                }
            }
        }
        return result;
    }
}
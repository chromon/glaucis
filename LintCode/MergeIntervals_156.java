/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList<>();
        
        if (intervals.size() == 0) {
            return result;
        }
        
        Collections.sort(intervals, new MyComparator());
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i = 0; i < intervals.size(); i ++) {
            Interval in = intervals.get(i);
            
            if(in.start > end) {
                result.add(new Interval(start, end));
                start = in.start;
                end = in.end;
            } else {
                end = Math.max(in.end, end);
            }
        }
        
        result.add(new Interval(start, end));
        
        return result;
        
    }
}

class MyComparator implements Comparator<Interval> {  
    @Override  
    public int compare(Interval a, Interval b) {  
        return a.start - b.start;  
    }  
}
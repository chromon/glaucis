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
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals, new MyComparator());
        
        for(int i = 0; i < intervals.size() - 1; i ++) {
            if(intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
        }
        
        return true;
    }
}


class MyComparator implements Comparator<Interval> {  
    @Override  
    public int compare(Interval a, Interval b) {  
        return a.start - b.start;  
    }  
}
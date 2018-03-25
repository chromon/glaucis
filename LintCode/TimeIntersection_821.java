/** 
 * Definition of Interval: 
 * public classs Interval { 
 *     int start, end; 
 *     Interval(int start, int end) { 
 *         this.start = start; 
 *         this.end = end; 
 *     } 
 */ 
public class Solution {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        // Write your code here
        
        int len = seqA.size() > seqB.size()? seqA.size(): seqB.size();
        List<Interval> list = new ArrayList<>();
        
        for(Interval a: seqA) {
            for(Interval b: seqB) {
                
                Interval p = new Interval(0, 0);
                if(a.start >= b.end || a.end <= b.start) {
                    continue;
                }
                
                if(a.start <= b.start && a.end <= b.end) {
                    p.start = b.start;
                    p.end = a.end;
                } else if(a.start > b.start && a.end < b.end) {
                    p.start = a.start;
                    p.end = a.end;
                } else if(a.start > b.start && a.end > b.end) {
                    p.start = a.start;
                    p.end = b.end;
                } else if(a.start < b.end && a.end > b.end) {
                    p.start = b.start;
                    p.end = b.end;
                }
                
                list.add(p);
            }
        }
        return list;
    }
}
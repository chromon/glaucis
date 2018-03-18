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
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        List<Interval> list = new ArrayList<>();
        List<Interval> result = new ArrayList<>();
        
        
        if (intervals.size() == 0) {
            return result;
        }
        
        for(List<Interval> l: intervals) {
            for(Interval inter: l) {
                list.add(inter);
            }
        }
        
        Collections.sort(list, new MyComparator());
        
        int start = list.get(0).start;
        int end = list.get(0).end;
        
        for(int i = 0; i < list.size(); i ++) {
            Interval in = list.get(i);
            
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
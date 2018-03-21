public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        // 同 156
        List<Interval> result = new ArrayList<>();
        
        for(Interval in: list2) {
            list1.add(in);
        }
        
        if (list1.size() == 0 && list2.size() == 0) {
            return result;
        } else if(list1.size() == 0 || list2.size() == 0) {
            return list1.size() == 0? list2: list1;
        }
        
        Collections.sort(list1, new MyComparator());
        
        int start = list1.get(0).start;
        int end = list1.get(0).end;
        
        for(int i = 0; i < list1.size(); i ++) {
            Interval in = list1.get(i);
            
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
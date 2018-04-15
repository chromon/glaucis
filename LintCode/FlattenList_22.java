/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    
    // List<Integer> res = new ArrayList<>();
        
    // public List<Integer> flatten(List<NestedInteger> nestedList) {
    //     // Write your code here
        
    //     if (nestedList == null || nestedList.size() == 0) {
    //         return res;
    //     }
        
    //     for (NestedInteger val: nestedList) {
    //         if(val.isInteger()) {
    //             res.add(val.getInteger());
    //         } else {
    //             flatten(val.getList());
    //         }
    //     }
        
    //     return res;
    // }
    
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        for (NestedInteger ele : nestedList)
            if (ele.isInteger())
                result.add(ele.getInteger());
            else
                result.addAll(flatten(ele.getList()));
        return result;
    }
    
    // public List<Integer> flatten(List<NestedInteger> nestedList) {
    //     // Write your code here
        
    //     boolean isFlat = true;
    //     List<NestedInteger> ls = nestedList;
        
    //     while (isFlat) {
    //         isFlat = false;
    //         List<NestedInteger> newLs = new ArrayList<>();
    //         for (NestedInteger ni : ls) {
    //             if (ni.isInteger()) {
    //                 newLs.add(ni);
    //             } else {
    //                 newLs.addAll(ni.getList());
    //                 isFlat = true;
    //             }
    //         }
    //         ls = newLs;
    //     }
        
    //     List<Integer> res = new ArrayList<>();
    //     for (NestedInteger ni : ls) {
    //         res.add(ni.getInteger());
    //     }
    //     return res;
    // }
}
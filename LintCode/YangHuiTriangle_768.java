public class Solution {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public List<List<Integer>> calcYangHuisTriangle(int n) {
        // write your code here
        List<List<Integer>> clist = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < n; i ++) {
            List<Integer> rlist = new ArrayList<Integer>();
            for(int j = 0; j <= i; j ++) {
                rlist.add(0);
            }
            clist.add(rlist);
        }
        
        for(int i = 0; i < n; i ++) {
            clist.get(i).set(0, 1);
            clist.get(i).set(i, 1);
        }
        
        for(int i = 2; i < n; i ++) {
            for(int j = 1; j < i; j ++) {
                clist.get(i).set(j, clist.get(i - 1).get(j - 1) + clist.get(i - 1).get(j));
            }
        }
        
        return clist;
    }
}
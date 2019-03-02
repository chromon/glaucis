class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (numRows == 0) {
            return res;
        }
        
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> currList = new ArrayList<>();
            List<Integer> preList = res.get(i - 1);
            
            // 第一个数字永远是 1
            currList.add(1);
            
            for (int j = 1; j < i; j++) {
                currList.add(preList.get(j - 1) + preList.get(j));
            }
            
            // 最后一个数字也是 1
            currList.add(1);
            
            res.add(currList);
        }
        
        return res;
    }
}
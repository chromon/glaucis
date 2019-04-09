class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (j < S.length()) {
            List<Integer> list = new ArrayList<>();
            if (S.charAt(i) == S.charAt(j)) {
                j++;
                if (j == S.length() && j - i > 2) {
                    list.add(i);
                    list.add(S.length() - 1);
                    res.add(list);
                }
            } else {
                if (j - i > 2) {
                    list.add(i);
                    list.add(j - 1);
                    res.add(list);
                    i = j;
                } else {
                    i++;
                    j = i;
                }
                
                if (i == S.length() - 1) {
                    break;
                }
            }
        }
        
        return res;
    }
}
public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        
        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < ca.length; i ++) {
            if(! map.containsKey(ca[i])) {
                map.put(ca[i], 1);
            } else {
                map.put(ca[i], map.get(ca[i]) + 1);
            }
        }
        
        for(int i = 0; i < cb.length; i ++) {
            if(! map.containsKey(cb[i])) {
                return false;
            } else {
                if(map.get(cb[i]) > 0) {
                    map.put(cb[i], map.get(cb[i]) - 1);
                } else {
                    return false;
                }
            }
        }
        
        // 最后每一个 value 都应该为 0，不能有剩余
        for(Integer v : map.values()) { 
            if(v != 0) {
                return false;
            }
        }
        
        return true;
    }
}
public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        
        Map<Character, Integer> map = new HashMap<>();
        
        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();
        
        for(int i = 0; i < ca.length; i ++) {
            if(! map.containsKey(ca[i])) {
                map.put(ca[i], 1);
            } else {
                map.put(ca[i], map.get(ca[i]) + 1);
            }
        }
        
        for(int i = 0; i < cb.length; i ++) {
            if(map.containsKey(cb[i]) && map.get(cb[i]) > 0) {
                map.put(cb[i], map.get(cb[i]) - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}
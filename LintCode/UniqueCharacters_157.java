public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        
        for(int i = 0; i < str.length() - 1; i ++) {
            for(int j = i + 1; j < str.length(); j ++) {
                if(str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
public class Solution {
    /**
     * @param str: The input string
     * @return: The answer
     */
    public String[] dataSegmentation(String str) {
        // Write your code here
        
        List<String> list = new ArrayList<>();
        String s = "";
        
        for(int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) == ' ') {
                if(s.length() != 0) {
                    list.add(s);
                }
                s = "";
            } else if(str.charAt(i) > 'z' || str.charAt(i) < 'a') {
                if(s.length() != 0) {
                    list.add(s);
                }
                
                s = "";
                s += str.charAt(i);
                list.add(s);
                s = "";
            } else {
                s += str.charAt(i);
            }
        }
        
        if(s.length() != 0) {
            list.add(s);
        }
        
        String[] res = list.toArray(new String[list.size()]);
        
        return res;
    }
}
public class Solution {
    /**
     * @param str: a string containing uppercase alphabets and integer digits
     * @return: the alphabets in the order followed by the sum of digits
     */
    public String rearrange(String str) {
        // Write your code here
        
        if(str.equals("")) {
            return "";
        }
        
        char[] c = str.toCharArray();
        int sum = 0;
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < c.length; i ++) {
            int t = c[i];
            
            if(t >= 48 && t <= 57) {
                sum += c[i] - '0';
                continue;
            }
            
            list.add(String.valueOf(c[i]));
        }
        
        Collections.sort(list);
        String[] s = list.toArray(new String[0]);
        
        String r = "";
        for(int i = 0; i < s.length; i ++) {
            r += s[i];
        }
        return r + sum;
    }
}
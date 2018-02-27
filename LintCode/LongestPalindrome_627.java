public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        
        /*
            利用map找到两个相同的字母，那么最后的长度就可以加2；
            如果map最后不为空，最后再加一即可。
        */
        
        if(s == null || s.length() == 0) {  
            return 0;  
        }  
        
        int length = s.length();  
        int count = 0;  
        HashMap<Character,Integer> map = new HashMap<Character,Integer>(); 
        
        for(int i = 0; i < length; i ++) {  
            if(! map.containsKey(s.charAt(i))) {  
                map.put(s.charAt(i),1);  
            } else if(map.get(s.charAt(i)) == 1) {  
                map.remove(s.charAt(i));  
                count ++;  
            }  
        }  
        count = count *2;  
        
        if(!map.isEmpty()){  
            count ++;  
        }  
        
        return count;   
    }
}
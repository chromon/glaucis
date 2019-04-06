class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String[] mc = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        if (words == null) {
            return 0;
        }
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            StringBuffer sbf = new StringBuffer();
            for (char c: words[i].toCharArray()) {
                sbf.append(mc[c - 'a']);
            }
            
            set.add(sbf.toString());
        }
        
        return set.size();
    }
}
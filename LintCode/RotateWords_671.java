public class Solution {
    /*
     * @param words: A list of words
     * @return: Return how many different rotate words
     */
    public int countRotateWords(List<String> words) {
        // Write your code here

        int count = 0;
        for(int i = 0; i < words.size(); i ++) {
            
            if(words.get(i) != null) {
                String tmp = words.get(i) + words.get(i);
                words.set(i, null);
                
                int t = 0;
                for(int j = 0; j < words.size(); j ++) {
                    if(words.get(j) != null && tmp.contains(words.get(j)) 
                        && tmp.length() == words.get(j).length() * 2) {
                        t ++;
                        words.set(j, null);
                    }
                }
                
                if(t >= 0) {
                    count ++;
                }
            }
        }
        return count;
    }
}
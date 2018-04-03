public class Solution {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    public List<String> longestWords(String[] dictionary) {
        // write your code here
        
        List<String> list = new ArrayList<>();
        
        int max = 0;
        for(String s: dictionary) {
            if(s.length() == max) {
                list.add(s);
            } else if(s.length() > max) {
                max = s.length();
                list.clear();
                list.add(s);
            }
        }
        
        return list;
    }
}
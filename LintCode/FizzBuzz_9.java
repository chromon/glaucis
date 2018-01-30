public class Solution {
    /*
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> strList = new ArrayList<>();
        
        for(int i = 1; i <= n; i ++) {
            if(i % 15 == 0) {
                strList.add("fizz buzz");
            } else if(i % 3 == 0) {
                strList.add("fizz");
            } else if(i % 5 == 0) {
                strList.add("buzz");
            } else {
                strList.add(String.valueOf(i));
            }
        }
        return strList;
    }
}
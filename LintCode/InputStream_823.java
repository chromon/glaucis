public class Solution {
    /**
     * @param inputA: Input stream A
     * @param inputB: Input stream B
     * @return: The answer
     */
    public String inputStream(String inputA, String inputB) {
        // Write your code here
        
        if(inputA == null | inputB == null) {
            return "NO";
        }
        
        char[] a = inputA.toCharArray();
        char[] b = inputB.toCharArray();
        
        List<Character> la = new LinkedList<>();
        List<Character> lb = new LinkedList<>();
        
        for(char c: a) {
            if(c == '<') {
                if(la.size() > 0) {
                    la.remove(la.size() - 1);
                }
            } else {
                la.add(c);
            }
        }
        
        for(char c: b) {
            if(c == '<') {
                if(lb.size() > 0) {
                    lb.remove(lb.size() - 1);
                }
            } else {
                lb.add(c);
            }
        }
        
        if(la.toString().equals(lb.toString())) {
            return "YES";
        }
        
        return "NO";
    }
}
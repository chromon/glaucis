public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        // "真实的"字符长度，指的是实际字符的数量，不包含末尾的终止符'\0'；
        
        if(length == 0) {
            return 0;
        }
        
        int count = 0;
        
        for(int i = 0; i < length; i ++) {
            if(string[i] == ' ') {
                count ++;
            }
        }
        
        int t = length + 2 * count;
        for(int i = length; i >= 0; i --) {
            if(string[i] == ' ') {
                string[t --] = '0';
                string[t --] = '2';
                string[t --] = '%';
            } else {
                string[t --] = string[i];
            }
        }
        
        return length + 2 * count;
    }
}
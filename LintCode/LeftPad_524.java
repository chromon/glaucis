public class StringUtils {
    /**
     * @param originalStr: the string we want to append to with spaces
     * @param size: the target length of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        
        if(originalStr.length() >= size) {
            return originalStr;
        }
        
        String s = "";
        for(int i = 0; i < size - originalStr.length(); i ++) {
            s += " ";
        }
        
        return s + originalStr;
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // write your code here
        
        if(originalStr.length() >= size) {
            return originalStr;
        }
        
        String s = "";
        for(int i = 0; i < size - originalStr.length(); i ++) {
            s += String.valueOf(padChar);
        }
        
        return s + originalStr;
    }
}
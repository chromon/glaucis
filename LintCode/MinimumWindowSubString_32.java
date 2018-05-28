public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        if (source.length() < target.length()){  
            return "";  
        }  
        for (int i = target.length(); i <= source.length(); i ++){  
            for (int j = 0; j + i <= source.length(); j ++){  
                String s = source.substring(j, j + i);  
                StringBuffer sb = new StringBuffer(s);  
                int count=0;  
                for (int k = 0;k < target.length(); k ++){  
                    if (sb.indexOf(target.charAt(k) + "") != -1){  
                        sb.deleteCharAt(sb.indexOf(target.charAt(k) + ""));  
                        count ++;  
                    } else {  
                        break;  
                    }  
                }  
                if (count == target.length()){  
                    return s;  
                }  
            }  
        }  
        return "";  
    }
}
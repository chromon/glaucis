class Solution {
    /*public String licenseKeyFormatting(String S, int K) {
        // 输入 "2-4A0r7-4k"  4
        // 输出 "2-4A0R-74K"
        // 预期 "24A0-R74K"
        // 除了第一个分组以外，每个分组要包含 K 个字符
        StringBuffer sbf = new StringBuffer();
        int i = 0;
        
        for (; i < S.length(); i++) {
            
            sbf.append(Character.toUpperCase(S.charAt(i)));
            
            if (S.charAt(i) == '-') {          
                i++;
                break;
            }
        }
        
        int count = K;
        
        for (; i < S.length(); i++) {
            if (S.charAt(i) != '-') {
                if (count > 0) {
                    sbf.append(Character.toUpperCase(S.charAt(i)));
                    count--;
                } else {
                    sbf.append('-');
                    sbf.append(Character.toUpperCase(S.charAt(i)));
                    count = K;
                }
            }
        }
        
        return sbf.toString();
    }*/
    
    public String licenseKeyFormatting(String S, int K) {
    
        S = S.toUpperCase();
        StringBuffer sbf = new StringBuffer();
        
        int count = 0;
        
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (count % K == 0 && count != 0) {
                    sbf.append('-');
                } 
                sbf.append(S.charAt(i));
                count++;
            }
        }
        
        return sbf.reverse().toString();
    }
    
}
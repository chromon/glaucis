class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        if(n <= 0) {
            return "";
        }
        
        if(n == 1) {
            return s;
        }
        
        for(int i = 1; i < n; i ++) {
            String tmp = "";
            int count = 1;
            
            char[] c = s.toCharArray();
            int j;
            
            // 判断长度大于 1 的情况 
            for(j = 0; j < c.length - 1; j ++) {
                if(c[j] == c[j + 1]) {
                    // 没有处理所有字符都一样的情况
                    count ++;
                }else {
                    // 没有处理最末尾的单独一个字符c[j + 1]
                    tmp += count + String.valueOf(c[j]);
                    count = 1;
                }
            }
            
            if(j > 0 && c[j] == c[j - 1]) {
                // 长度大于 1 并且只包含一种字符
                tmp += count + String.valueOf(c[j]);
            } else if(j == 0) {
                // 长度为 1
                tmp += 1 + String.valueOf(c[j]);
            } else {
                // 添加最末尾的字符
                tmp += 1 + String.valueOf(c[j]);
            }
            
            s = tmp;
        }
        
        return s;
    }
}
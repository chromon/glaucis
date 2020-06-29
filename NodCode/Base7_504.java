class Solution {
    public String convertToBase7(int num) {
        
        if (num == 0) {
            return "0";
        }
        
        String res = "";
        int tmp = 1;
        
        if (num < 0) {
            num = -num;
            tmp = -1;
        }
        
        while (num != 0) {
            res = num % 7 + res;
            num = num / 7;
        }
        
        if (tmp == -1) {
            res = "-" + res;
        }
        
        return res;
    }
}
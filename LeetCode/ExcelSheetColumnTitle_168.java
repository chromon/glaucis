class Solution {
    public String convertToTitle(int n) {
        
        String sf = "";
        
        while (n != 0) {
            // A 是从 1 开始的，实质上是应该从 0 开始，所以要 -1 来取得平衡
            n--;
            sf = String.valueOf((char)(n % 26 + 65)) + sf;
            n = n / 26;
        }
        
        return sf;
    }
}
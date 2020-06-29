class Solution {
    public int repeatedStringMatch(String A, String B) {
        /*
            计算循环次数，为了让B字串从A字串任意位置开始并且全部被包含，
            所以用len(B) / len(A) + 1。
            每循环一次，令A字串末尾添加一次并判断是否包含B。
            最后循环结束的时候因为最后添加的一次没有判断，需要再次进行判断。
        */
        int loop = B.length() / A.length() + 1;
        StringBuffer sbf = new StringBuffer(A);
        int i = 0;
        
        for (; i < loop; i++) {
            if (sbf.toString().contains(B))
                return i + 1;
            sbf.append(A);
        }
        
        return sbf.toString().contains(B) ? i + 1 : -1;
    }
}
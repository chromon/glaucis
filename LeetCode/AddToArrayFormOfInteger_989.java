class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        
        int len = new String(K + "").length();
        int carry = 0;
        
        List<Integer> res = new LinkedList<>();
        
        for (int i = 0; i < A.length || i < len; i++) {
            int bit = 0;
            if (i < A.length) {
                bit = A[A.length - i - 1] + K % 10 + carry;
            } else {
                bit = K % 10 + carry;
            }
            
            res.add(0, bit % 10);
            carry = bit / 10;
            K = K / 10;
        }
        
        if (carry > 0) {
            res.add(0, carry);
        }
        
        return res;
    }
}
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        
        // 遇到 1 就多跳一次
        int i = 0;
        
        for (; i < bits.length - 1; i++) {
            if (bits[i] == 1) {
                i++;
            }
        }
        
        return i != bits.length;
    }
}
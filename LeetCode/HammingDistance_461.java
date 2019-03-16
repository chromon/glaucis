class Solution {
    public int hammingDistance(int x, int y) {
        // 假如数为num, num & (num - 1)可以快速地移除最右边的bit 1， 
        // 一直循环到num为0, 总的循环数就是num中bit 1的个数
        
        // 先异或求不同位个数再数 1
        int sum = 0;
        int z = x ^ y;
        
        while (z != 0) {
            sum++;
            z = z & (z - 1);
        }
        
        return sum;
    }
}
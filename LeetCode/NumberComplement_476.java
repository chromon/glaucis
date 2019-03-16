class Solution {
    public int findComplement(int num) {
        /*
        如果我们能知道该数最高位的1所在的位置，就可以构造一个长度和该数据所占位置一样长的一个掩码mask，然后概述和mask进行异或即可。
        
        5的二进制是101，我们的构造的掩码为mask=111，两者异或则为010，即是所要的结果。
        */
        int mask = 1;
        int tmp = num;
        
        while (tmp > 0) {
            tmp = tmp >> 1;
            mask = mask << 1;
        }
        
        return num ^ (mask - 1);
    }
}
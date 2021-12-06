/*
650. 2 Keys Keyboard
Medium

There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

 

Example 1:

Input: n = 3
Output: 3
Explanation: Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Example 2:

Input: n = 1
Output: 0
 

Constraints:

1 <= n <= 1000
*/


/*

当起始只有一个'A'的情况下，一种得到36个'A'的方案为：

复制 1 次，粘贴 2 次，得到 'AAA'
在上面的基础上，复制 1 次，粘贴 2 次，得到 'AAAAAAAAA'
在上面的基础上，复制 1 次，粘贴 1 次，得到 18 个 'A'
在上面的基础上，复制 1 次，粘贴 1 次，得到 36 个 'A'
因为复制和粘贴都算一次操作，所以上面得到了 3 * 3 * 2 * 2 = 36 个'A'


如果 n 是素数的话，只能通过复制 1 次A，然后粘贴 n - 1 次的方式才能得到 n 个A。总的操作了 n 次。

如果 n = i * j 的话，最快得到 n 的方式是先得到 i ，复制 1 次，然后再粘贴 j - 1 次，总的就有了 n 个A。总的操作了 minSteps(i) + 1 + j - 1 = minSteps(i) + j = minSteps(i) + n / i 次。
*/
class Solution {
    /*
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }   
        
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return minSteps(n / i) + i;
            }
        }
        
        return n;
    }
    */
    
    /* 
        可以发现题目要求的就是 36 的所有素因子之和。素因子是指，该因子不可再次拆分。
        36 = 3 * 3 * 2 * 2
    
        具体证明就是要证明 m * n > m + n，
        等价于求 (m - 1)*(n - 1) > 1，当 m 和 n 大于 2 的时候上式永远成立。

        代码求 n 能拆成哪些素因子。让 d 试探是否为因子从 2 开始递增，
        如果 n 能被 d 整除时，此时的 d 是 n 的一个素因子，求复制粘贴次数的结果中增加 d ；
        而且如果 d 是个素因子，那么要一次性把 n 中除掉所有的 d。
    */
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
/*
202. Happy Number
Easy

Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

/*
快慢指针的方法，或者叫 Floyd Cycle detection algorithm。

原理也很好理解，想象一下圆形跑道，两个人跑步，如果一个人跑的快，一个人跑的慢，
那么不管两个人从哪个位置出发，跑的过程中两人一定会相遇。

所以这里我们用两个指针 fast 和 slow。fast 每次走两步，slow 每次走一步。

如果有重复的数字的话，fast 和 slow 就一定会相遇。

没有重复数字的话，当 fast 经过 1 的时候，就会停下来了。然后 slow 最终也会走向 1，所以也会相遇。

因此，代码的话，当 fast 和 slow 相遇的时候只需要判断当前是否是 1 即可。
*/

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        while (true) {
            slow = cal(slow);
            if (slow == 1) {
                return true;
            }
            
            fast = cal(cal(fast));
            if (fast == 1) {
                return true;
            }
            
            if (slow == fast) {
                return false;
            }
        }
    }
    
    public int cal(int n) {
        int s = 0;
        
        while (n > 0) {
            s += (n % 10) * (n % 10);
            n /= 10;
        }
        
        return s;
    }
}
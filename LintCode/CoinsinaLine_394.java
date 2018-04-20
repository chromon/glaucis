public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        /*
        以看到数据肯定可以保证3个一轮，因为你拿1个，我就2个，你拿2个，我就1个，
        也就是说如果是3的倍数，肯定是后手赢，先手可以拿1-2个把总数改成3的倍数
        */
        return n % 3 != 0;
    }
}
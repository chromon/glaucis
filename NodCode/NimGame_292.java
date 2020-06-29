class Solution {
    public boolean canWinNim(int n) {
        // 如果堆中石头的数量 nn 不能被 44 整除，那么你总是可以赢得 Nim 游戏的胜利。
        // 巴什博奕，n % (m + 1) != 0 时，先手总是会赢的
        return (n % 4 != 0);
    }
}
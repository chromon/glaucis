package level4;

/*
    1179: 最大的最大公约数
    给出N个正整数，找出N个数两两之间最大公约数的最大值。
    例如：N = 4，4个数为：9 15 25 16，两两之间最大公约数的最大值是15同25的最大公约数5。

    Input
    第1行：一个数N，表示输入正整数的数量。(2 <= N <= 50000)
    第2 - N + 1行：每行1个数，对应输入的正整数.(1 <= S[i] <= 1000000)

    Output
    输出两两之间最大公约数的最大值。

    Input 示例
    4
    9
    15
    25
    16

    Output 示例
    5

   Created by Ellery on 2016/11/18.
 */

import java.io.BufferedInputStream;
import java.util.Scanner;

public class N1179 {

    private int n;

    private int MAX = 1000000;

    private int[] s, r;

    public N1179() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.n = scanner.nextInt();

        this.s = new int[MAX];

        for (int i = 0; i < this.n; i ++) {
            int x = scanner.nextInt();
            s[x] ++;
        }
    }

    private void getMax() {
        int ans = 1;
        for(int i = 2; i < MAX; i ++) {
            int tmp = 0;
            for(int j = i; j < MAX; j += i) {
                tmp += s[j];
            }
            if(tmp >= 2) {
                ans=i;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        N1179 n = new N1179();
        n.getMax();
    }
}

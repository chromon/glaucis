package basic;

/*
    1008: N 的阶乘 mod P
    输入 N 和 P（P 为质数），求 N! Mod P = ? ( Mod 就是求模 %)
    例如：n = 10， P = 11，10! = 3628800
    3628800 % 11 = 10

    Input
    两个数 N, P ，中间用空格隔开。(N < 10000, P < 10^9)

    Output
    输出 N! mod P的结果。

    Input 示例
    10 11

    Output 示例
    10

    Created by Ellery on 2016/11/14.
 */

/*
    (a * b) % p = (a % p * b % p) % p
    =>
    N！ % P = (（N-1）!  % P) * N % P
            = mod1 * mod2.....*modN
 */

import java.util.Scanner;

public class N1008 {

    private long result;

    private long n, p;

    public N1008() {
        Scanner scanner = new Scanner(System.in);
        this.n = Long.parseLong(scanner.next());
        this.p = Long.parseLong(scanner.next());

        this.result = 1;
    }

    private void mod() {


        for (long i = 1; i <= n; i ++) {
            this.result = (this.result * i ) % this.p;
            if (result == 0) {
                break;
            }
        }

        System.out.println(this.result);
    }

    public static void main(String[] args) {

        N1008 n = new N1008();
        n.mod();
    }
}

package basic;

/*
    1130: N的阶乘的长度 V2（斯特林近似）
    输入N求N的阶乘的10进制表示的长度。例如6! = 720，长度为3。

    Input
    第1行：一个数T，表示后面用作输入测试的数的数量。（1 <= T <= 1000) 第2 - T + 1行：每行1个数N。（1 <= N <= 10^9)

    Output
    共T行，输出对应的阶乘的长度。

    Input 示例
    3
    4
    5
    6

    Output 示例
    2
    3
    3

    Created by Ellery on 2016/11/13.
 */

import java.util.Scanner;

public class N1130 {

    private static long stirling(long n) {

        // 斯特林公式 n!=sqrt(2*PI*n)*(n/e)^n
        // stirling = 0.5*log10(2.0*PI*n)+n*log10(n*1.0/e)+1;
        double len = 0.5 * Math.log10(2.0 * Math.PI * n) + n * Math.log10(n * 1.0 / Math.E) + 1;

        return (long) Math.floor(len);
    }

    public static void main(String[] args) {

        // 斯特林公式n!=sqrt(2*PI*n)*(n/e)^n
        // len=0.5*log10(2.0*PI*n)+n*log10(n*1.0/e)+1;

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i ++) {
            long n = scanner.nextLong();
            long len = N1130.stirling(n);
            System.out.println(len);
        }
    }
}

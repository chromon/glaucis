package basic;

/*
    1058: N的阶乘的长度
    输入N求N的阶乘的10进制表示的长度。例如6! = 720，长度为3。

    Input
    输入N(1 <= N <= 10^6)

    Output
    输出N的阶乘的长度

    Input 示例
    6

    Output 示例
    3

    Created by Ellery on 2016/11/13.
 */

import java.util.Scanner;

public class N1058 {

    public static void main(String[] args) {

        // 斯特林公式n!=sqrt(2*PI*n)*(n/e)^n
        // len=0.5*log10(2.0*PI*n)+n*log10(n*1.0/e)+1;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double len = 0.5 * Math.log10(2.0 * Math.PI * n) + n * Math.log10(n * 1.0 / Math.E) + 1;

        System.out.println((int) Math.floor(len));
    }

}

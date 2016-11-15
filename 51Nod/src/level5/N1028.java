package level5;

/*
    1028 大数乘法
    基准时间限制：1 秒 空间限制：131072 KB
    给出2个大整数A,B，计算A*B的结果。

    Input
    第1行：大数A
    第2行：大数B
    (A,B的长度 <= 100000，A,B >= 0）

    Output
    输出A * B

    Input示例
    123456
    234567

    Output示例
    28958703552

    Created by Ellery on 2016/11/11.
 */

/*
    应该使用FFT（快速傅里叶算法）计算，好难，实在是看不懂 ……
 */

import java.math.BigInteger;
import java.util.Scanner;

public class N1028 {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       BigInteger a = scanner.nextBigInteger();
       BigInteger b = scanner.nextBigInteger();

       System.out.println(a.multiply(b));
    }
}

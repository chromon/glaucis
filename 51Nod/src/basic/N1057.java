package basic;

/*
    1057 N的阶乘
    基准时间限制：1 秒 空间限制：131072 KB
    输入N求N的阶乘的准确值。

    Input
    输入N(1 <= N <= 10000)

    Output
    输出N的阶乘

    Input示例
    5

    Output示例
    120

    Created by Ellery on 2016/11/12.
 */

import java.util.Locale;
import java.util.Scanner;

public class N1057 {

    private long[] result;

    private final long MAX = 1000000000000L;
    private int num;

    private N1057() {

        Scanner scanner = new Scanner(System.in);
        this.num = Integer.parseInt(scanner.next());

        this.result = new long[100000];
        this.result[0] = 1;
    }

    private void factorial() {

        // 进位
        long c;

        // 数组向右移动
        int m = 0;

        for (int i = 1; i <= this.num; i ++) {
            c = 0;
            for (int j = 0; j <= m; j ++) {
                result[j] = result[j] * i + c;
                // 进位
                c = result[j] / MAX;
                // 余数
                result[j] = result[j] % MAX;
            }

            // 当前元素总大小超过一个数组元素最大值，超出的部分为进位 c
            if (c > 0) {
                m ++;
                result[m] = c;
            }
        }

//        System.out.println(m); // 100000! = 38047
//
//        int count = (result[m] + "").length() + m*12;
//        System.out.println(count); // 456574

        // 数组中最后一个存在值的元素，即为结果的最高几位（元素的大小可能小于数组元素的最大值）
        System.out.println(result[m]);
        // 剩余 m - 1 位数组元素元素（每位长度均为最大值），倒序输出
        for (int i = m - 1; i >= 0; i --) {
            System.out.println(String.format(Locale.getDefault(), "%012d", result[i]));
        }

    }

    public static void main(String[] args) {
        N1057 n = new N1057();
        n.factorial();
    }
}

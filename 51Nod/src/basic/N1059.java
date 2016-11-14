package basic;

/*
    1059: N的阶乘 V2
    输入N，求N的阶乘的准确值。

    Input
    输入N(1 <= N <= 100000)

    Output
    输出N的阶乘，由于数据量太大，请以1000个字符为单位，输出到一行里，最终剩余的不足1000个字符的部分，输出到单独1行。

    Input 示例
    5

    Output 示例
    120

    Created by Ellery on 2016/11/13.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class N1059 {

    private long[] result;

    private final long MAX = 1000000000000L;
    private int num;

    private PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private long start, end;

    private N1059() {

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.num = Integer.parseInt(scanner.next());

        this.start = System.currentTimeMillis();

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
        int count = (result[m] + "").length() + m*12;
//        System.out.println(count); //100000! = 456574

        StringBuilder s = new StringBuilder();
        // 数组中最后一个存在值的元素，即为结果的最高几位（元素的大小可能小于数组元素的最大值）

        s.append(result[m]);
        // 剩余 m - 1 位数组元素元素（每位长度均为最大值），倒序输出
        for (int i = m - 1; i >= 0; i --) {
            // 非首尾，数字可能是以 0 开头，要补上
            s.append(String.format(Locale.getDefault(), "%012d", result[i]));
        }

        if (count <= 1000) {
//            out.println(s.toString());
            out.println(s);
        } else {

            for (int i = 0; i < (count / 1000) * 1000; ) {
                out.println(s.substring(i, i + 1000));
                i += 1000;
            }
            out.println(s.substring((count / 1000) * 1000));
        }

        this.end = System.currentTimeMillis();
        out.println(end - start);

        out.flush();
    }

    public static void main(String[] args) {
        N1059 n = new N1059();
        n.factorial();
    }
}

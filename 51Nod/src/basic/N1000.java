package basic;

/*
 * 1000 A+B
 * 给出2个整数A和B，计算两个数的和。
 *
 * Input
 * 2个整数A B，中间用空格分割。（0 <= A, B <= 10^9）
 *
 * Output
 * 输出A + B的计算结果。
 *
 * Input示例
 * 1 2
 *
 * Output示例
 * 3
 *
 * Created by Ellery on 2016/11/06.
 */

import java.util.Scanner;

public class N1000 {

    private static int add() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add());
    }
}

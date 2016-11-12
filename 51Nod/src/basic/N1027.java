package basic;

/*
    1027 大数乘法
    基准时间限制：1 秒 空间限制：131072 KB
    给出2个大整数A,B，计算A*B的结果。

    Input
    第1行：大数A
    第2行：大数B
    (A,B的长度 <= 1000，A,B >= 0）

    Output
    输出A * B

    Input示例
    123456
    234567

    Output示例
    28958703552

    Created by Ellery on 2016/11/11.
 */

import java.util.Scanner;

public class N1027 {

    private char[] charNumA, charNumB;

    private int[] numA, numB;

    private int[] result;

    private void getData() {
        Scanner scanner = new Scanner(System.in);

        this.charNumA = scanner.next().toCharArray();
        this.charNumB = scanner.next().toCharArray();

        this.numA = new int[this.charNumA.length];
        this.numB = new int[this.charNumB.length];

        this.result = new int[this.charNumA.length + this.charNumB.length + 1];
    }

    private void swap() {

        for (int i = this.charNumA.length - 1, j = 0; i >= 0; i --) {
            this.numA[j++] = Integer.parseInt(String.valueOf(this.charNumA[i]));
        }

        for (int i = this.charNumB.length - 1, j = 0; i >= 0; i --) {
            this.numB[j++] = Integer.parseInt(String.valueOf(this.charNumB[i]));
        }
    }

    private void multiply() {

        // 每次相乘完成，向前移动一位
        int c = 0;

        for (int i = 0; i < this.numA.length; i ++) {
            for (int j = 0; j < this.numB.length; j ++) {
                result[j + c] += numA[i] * numB[j];
                // 进位
                result[j + c + 1] += result[j + c] / 10;
                // 余数
                result[j + c] = result[j + c] % 10;
            }
            c ++;
        }
    }

    private void display() {
        this.getData();
        this.swap();
        this.multiply();

        boolean flag = true;
        for (int i = this.result.length - 1; i >= 0; i --) {
            if (this.result[i] == 0 && flag) {
               continue;
            } else {
                flag = false;
            }
            System.out.print(this.result[i]);
        }
    }

    public static void main(String[] args) {
        N1027 n = new N1027();
        n.display();
    }
}

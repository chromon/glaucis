package basic;

/*
 * 1000 大数加法
 * 给出2个大整数 A,B，计算 A+B 的结果。
 *
 * Input
 * 第1行：大数 A
 * 第2行：大数 B
 * (A,B 的长度 <= 10000 需注意：A B 有可能为负数）
 *
 * Output
 * 输出 A + B
 *
 * Input 示例
 * 68932147586
 * 468711654886
 *
 * Output 示例
 * 537643802472
 *
 * Created by Ellery on 2016/11/07.
 */

import java.util.Scanner;

public class N1005 {

    private char[] charNumA, charNumB;

    private int tempA, tempB;

    private int[] numA, numB;

    private int maxLength;

    private void getData() {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();

        this.charNumA = num1.toCharArray();
        this.charNumB = num2.toCharArray();

        if (this.charNumA[0] == '-') {
            this.tempA = 1;
        }
        if (this.charNumB[0] == '-') {
            this.tempB = 1;
        }
    }

    private void swap() {

        // 去掉符号的实际长度
        int lengthA = (tempA == 1)? this.charNumA.length - 1: this.charNumA.length;
        int lengthB = (tempB == 1)? this.charNumB.length - 1: this.charNumB.length;

        this.maxLength = lengthA > lengthB? lengthA: lengthB;

        // 两数最大值长度
        this.numA = new int[this.maxLength];
        this.numB = new int[this.maxLength];

        // 逆向循环赋值
        for (int i = (this.tempA == 1? lengthA: lengthA - 1), j = 0; i >= this.tempA; i --) {
            this.numA[j++] = Integer.parseInt(String.valueOf(this.charNumA[i]));
        }

        for (int i = (this.tempB == 1? lengthB: lengthB - 1), j = 0; i >= this.tempB; i --) {
            this.numB[j++] = Integer.parseInt(String.valueOf(this.charNumB[i]));
        }
    }

    private void add() {

        // 逆序保存
        this.swap();

        int[] result = new int[maxLength];

        int t = 0;

        for (int i = 0; i < maxLength; i++) {
            result[i] = this.numA[i] + this.numB[i] + t;
            t = result[i] / 10;
            result[i] = result[i] % 10;
        }

        if (this.tempA == 1) {
            System.out.print("-");
        }
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }

    private boolean compare() {

        if (this.charNumA.length - this.tempA > this.charNumB.length - this.tempB) {
            // A > B
            return true;
        } else if (this.charNumA.length - this.tempA < this.charNumB.length - this.tempB) {
            // A < B
            return false;
        } else {
            int i;
            for (i = 0; i < this.charNumA.length && this.charNumA[i + this.tempA] == this.charNumB[i + this.tempB]; i ++);
            if (this.charNumA[i + this.tempA] > this.charNumB[i + this.tempB]) {
                // A > B
                return true;
            }
            // A < B
            return false;
        }
    }

    private void minus() {

        // A < B 则 AB 互换
        if (!this.compare()) {
            char[] temChar = this.charNumA;
            this.charNumA = this.charNumB;
            this.charNumB = temChar;

            int tem = this.tempA;
            this.tempA = this.tempB;
            this.tempB = tem;
        }

        this.swap();

        int[] result = new int[maxLength];

        int t = 0;
        int m = -1;

        for (int i = 0; i < this.maxLength; i ++) {
            int s = this.numA[i] - this.numB[i] - t >= 0? 0: 1;
            result[i] = (this.numA[i] - this.numB[i] - t + 10) % 10;
            m = result[i] > 0 ? i: m;
            t = s;
        }

        if (m < 0) {
            System.out.print("0");
        } else {
            if (this.tempA == 1) {
                System.out.print("-");
            }
            for (int i = result.length - 1; i >= 0; i--) {
                System.out.print(result[i]);
            }
        }
    }

    private void getResult() {
        this.getData();

        if (this.tempA != this.tempB) {
            this.minus();
        } else {
            this.add();
        }
    }

    public static void main(String[] args) {
        N1005 n = new N1005();
        n.getResult();
    }
}

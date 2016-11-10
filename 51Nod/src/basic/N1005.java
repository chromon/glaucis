package basic;

/*
 * 1000 大数加法
 * 给出2个大整数A,B，计算A+B的结果。
 *
 * Input
 * 第1行：大数A
 * 第2行：大数B
 * (A,B的长度 <= 10000 需注意：A B有可能为负数）
 *
 * Output
 * 输出A + B
 *
 * Input示例
 * 68932147586
 * 468711654886
 *
 * Output示例
 * 537643802472
 *
 * @author Ellery
 * @Date 2016-11-07
 */

import java.util.Scanner;

public class N1005 {

    private char[] charNumA;
    private char[] charNumB;

    private int[] numA;
    private int[] numB;

    private char numASign = '+';
    private char numBSign = '+';

    private char finalSign = '+';

    private int length = 0;

    private void getData() {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String num2 = scanner.next();

        if (num1.charAt(0) == '-') {
            num1 = num1.replaceAll("-", "");
            this.numASign = '-';
        } else if (num2.charAt(0) == '-') {
            num2 = num2.replaceAll("-", "");
            this.numBSign = '-';
        }

        this.charNumA = num1.toCharArray();
        this.charNumB = num2.toCharArray();
    }

    private void swap() {

        // 取长度最大值
        this.length = this.charNumA.length > this.charNumB.length ? this.charNumA.length : this.charNumB.length;

        // 两数相加最大值长度加1
        this.numA = new int[this.length + 1];
        this.numB = new int[this.length];

        // 逆向循环赋值
        for (int i = this.charNumA.length - 1, j = 0; i >= 0; i --) {
            this.numA[j++] = Integer.parseInt(String.valueOf(this.charNumA[i]));
        }

        for (int i = this.charNumB.length - 1, j = 0; i >= 0; i --) {
            this.numB[j++] = Integer.parseInt(String.valueOf(this.charNumB[i]));
        }
    }

    private void add() {

        this.swap();

        // 逐位相加
        for (int i = 0; i < this.length; i ++) {
            this.numA[i] += this.numB[i];
            if (this.numA[i] > 9) {
                this.numA[i] -= 10;
                this.numA[i+1] ++;
            }
        }

        // 判断结果符号
        if (finalSign == '-') {
            System.out.print(finalSign);
        }

        // 倒叙输出
        boolean flag = true;
        for (int i = this.length - 1; i >= 0; i --) {
            if (this.numA[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            System.out.print(this.numA[i]);
        }
    }

    private void minus() {
        // 判断 n1 - n2 谁大 ==> 得出计算符号与 finalSign 合并
        this.swap();

        int[] result = new int[this.length];
        char tempSign = '+';

        boolean bitTemp = false;

        // numA 长度为原长度 +1
        if (this.numA.length-1 < this.numB.length) {
            tempSign = '-';

        } else if (this.numA.length-1 == this.numB.length) {
            int i = (this.numA.length - 1) - 1;
            while (i > 0 && numA[i] == numB[i]) {
                i--;
            }
            if (this.numA[i] < this.numB[i]) {
                tempSign = '-';
            }
        }

        for (int i = 0; i < this.length; i++) {
            result[i] = this.numA[i] - this.numB[i];
            if (result[i] < 0) {
                this.numA[i+1] --;
                // result[i] += 10;
            }
        }

        // 判断符号
        if ((this.finalSign == '-' && tempSign == '+') || (this.finalSign == '+' && tempSign == '-')) {
            System.out.print('-');
        }

        // 倒叙输出
        boolean flag = true;
        for (int i = this.length - 1; i >= 0; i --) {
            if (result[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            System.out.print(Math.abs(result[i]));
        }


    }

    private void getResult() {
    /*
    *
    * n1 + n2               add
    * n1 + -n2  n1 - n2     minus
    * -n1 + n2  -(n1 - n2)  minus
    * -n1 + -n2 -(n1 + n2)  add
    *
    */
        this.getData();

        if (numASign == '+' && numBSign == '+') {
            this.add();
        } else if (numASign == '-' && numBSign == '-') {
            this.finalSign = '-';
            this.add();
        } else if (numASign == '+' && numBSign == '-') {
            this.minus();
        } else if (numASign == '-' && numBSign == '+') {
            this.finalSign = '-';
            this.minus();
        }
    }

    public static void main(String[] args) {
        N1005 n = new N1005();
        n.getResult();
    }
}

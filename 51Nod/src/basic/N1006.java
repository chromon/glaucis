package basic;

/*
 * 最长公共子序列 Lcs
 * 给出两个字符串 A B，求 A 与 B 的最长公共子序列（子序列不要求是连续的）。 比如两个串为：
 * abcicba
 * abdkscab
 * ab 是两个串的子序列，abc 也是，abca 也是，其中 abca 是这两个字符串最长的子序列。
 *
 * Input
 * 第1行：字符串 A
 * 第2行：字符串 B
 * (A,B 的长度 <= 1000）
 *
 * Output
 * 输出最长的子序列，如果有多个，随意输出1个。
 *
 * Input 示例
 * abcicba
 * abdkscab
 *
 * Output 示例
 * abca
 *
 * Created by Ellery on 2016/11/10.
 */

import java.util.Scanner;

public class N1006 {

    /*
        x = {x1, x2...xi}
        y = {y1, y2...yj}

                    |-   0;                             (i = 0 或 j = 0)
        c[i, j] =   |-   c[i - 1, j - 1] + 1;           (i, j > 0 && xi == yj)
                    |-   max(c[i, j - 1], c[i - 1, j])  (i, j > 0 && xi != yj)

     */

    private char[] x, y;

    private int[][] matrix;
    private String[][] flag;

    private StringBuffer result = new StringBuffer();

    private void getData() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        this.x = s1.toCharArray();
        this.y = s2.toCharArray();

        this.matrix = new int[this.x.length + 1][this.y.length + 1];
        this.flag = new String[this.x.length + 1][this.y.length + 1];
    }

    private void lcs() {
        for (int i = 1; i <= this.x.length; i ++) {
            for (int j = 1; j <= this.y.length; j ++) {

                if (this.x[i - 1] == this.y[j - 1]) {
                    // xi == yj
                    this.matrix[i][j] = this.matrix[i - 1][j - 1] + 1;
                    this.flag[i][j] = "left_up";
                } else {
                    // xi != yj
                    if (this.matrix[i][j - 1] >= this.matrix[i - 1][j] ) {
                        this.matrix[i][j] = this.matrix[i][j - 1];
                        this.flag[i][j] = "up";
                    } else {
                        this.matrix[i][j] = this.matrix[i - 1][j];
                        this.flag[i][j] = "left";
                    }
                }
            }
        }
    }

    private void subSequence(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (this.flag[i][j].equals("left_up")) {
            result.append(this.y[j - 1]);
            subSequence(i - 1, j - 1);
        } else {
            if (this.flag[i][j].equals("up")) {
                subSequence(i, j - 1);
            } else {
                subSequence(i - 1, j);
            }
        }

    }

    private void display() {
        this.getData();
        this.lcs();
        this.subSequence(this.x.length, this.y.length);
        System.out.println(this.result.reverse());
    }

    public static void main(String[] args) {
        N1006 n = new N1006();
        n.display();
    }
}

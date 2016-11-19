package basic;

/*
    1019: 逆序数
    在一个排列中，如果一对数的前后位置与大小顺序相反，即前面的数大于后面的数，那么它们就称为一个逆序。
    一个排列中逆序的总数就称为这个排列的逆序数。
    如2 4 3 1中，2 1，4 3，4 1，3 1是逆序，逆序数是4。给出一个整数序列，求该序列的逆序数。

    Input
    第1行：N，N为序列的长度（n <= 50000)
    第2 - N + 1行：序列中的元素（0 <= A[i] <= 10^9）

    Output
    输出逆序数

    Input 示例
    4
    2
    4
    3
    1

    Output 示例

    4

 * Created by Ellery on 2016/11/18.
 */

import java.io.*;

public class N1019 {

    private int n;

    private int[] s;

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            new InputStreamReader(System.in)));
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public N1019() {

        try {
            in.nextToken();
            this.n = (int) in.nval;

            this.s = new int[this.n];
            for (int i = 0; i < this.n; i ++) {
                in.nextToken();
                this.s[i] = (int) in.nval;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inverse() {

        int t = 0;
        for (int i = 0; i < this.n - 1; i ++) {
            for (int j = i + 1; j < this.n; j ++) {
                if (s[i] > s[j]) {
                    t ++;
                }
            }
        }

        out.println(t);
        out.flush();
    }

    public static void main(String[] args) {
        N1019 n = new N1019();
        n.inverse();
    }
}

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
    private int count;

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

    /**
     * 归并排序 O(nlogn)
     * @param lo 起始区间，闭区间
     * @param hi 结束区间，开区间
     */
    public int[] mergeSort(int[] _elem, int lo, int hi) {

        int mi = (lo + hi) >> 1;
        if (2 <= hi - lo) {
            // 前后两段分开排序
            mergeSort(_elem, lo, mi);
            mergeSort(_elem, mi , hi);

            // 前后二路归并
            merge(_elem, lo, mi, hi);
        }
        return _elem;
    }

    /**
     * 归并排序 二路归并
     * @param lo 起始区间，闭区间
     * @param mi 区间分隔
     * @param hi 结束区间，开区间
     */
    public void merge(int[] _elem, int lo, int mi, int hi) {

        // 临时数组
        int k = 0;
        int[] temp = new int[hi - lo];

        // 前后分段起始位置
        int i = lo, j = mi;

        // 把较小的数先移到新数组中。两段中一段越界，就全部终止，另一段剩余部分直接复制到临时数组
        while (i < mi && j < hi) {
            if (_elem[i] <= _elem[j]) {
                temp[k ++] = _elem[i ++];
            } else {
                temp[k ++] = _elem[j ++];

                count += mi - i;
            }
        }

        // 把前一分段剩余的数移入数组
        while (i < mi) {
            temp[k ++] = _elem[i ++];
        }

        // 把一分段剩余的数移入数组
        while (j < hi) {
            temp[k ++] = _elem[j ++];
        }

        // 把新数组中的数覆盖 _elem 数组
        for (k = 0; k < temp.length; k++) {
            _elem[k + lo] = temp[k];
        }
    }

    private void inverse() {

        this.mergeSort(s, 0, s.length);

        out.println(this.count);
        out.flush();
    }

    public static void main(String[] args) {
        N1019 n = new N1019();
        n.inverse();
    }
}

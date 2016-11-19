package basic;

/*
    1018: 排序
    给出N个整数，对着N个整数进行排序

    Input
    第1行：整数的数量N（1 <= N <= 50000)
    第2 - N + 1行：待排序的整数（-10^9 <= A[i] <= 10^9）

    Output
    共n行，按照递增序输出排序好的数据。

    Input 示例
    5
    5
    4
    3
    2
    1

    Output 示例
    1
    2
    3
    4
    5

   Created by Ellery on 2016/11/18.
 */

import java.io.BufferedInputStream;
import java.util.Scanner;

public class N1018 {

    private int n;

    private int[] s;

    public N1018() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.n = scanner.nextInt();

        this.s = new int[this.n];
        for (int i = 0; i < this.n; i ++) {
            this.s[i] = scanner.nextInt();
        }
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            int key = s[left];
            int low = left;
            int high = right;
            while (low < high) {

                // high下标位置开始，向左边遍历，查找不大于基准数的元素
                while (low < high && s[high] >= key) {
                    high --;
                }

                if (low < high) {
                    // 找到小于准基数key的元素
                    // 赋值给low下标位置，low下标位置元素已经与基准数对比过了
                    s[low] = s[high];
                    // low下标后移
                    low ++;
                } else {
                    // 没有找到比准基数小的元素
                    // 说明high位置右边元素都不小于准基数
                    break;
                }

                // low下标位置开始，向右边遍历，查找不小于基准数的元素
                while (low < high && s[low] <= key) {
                    low++;
                }

                if (low < high) {
                    // 找到比基准数大的元素
                    // 赋值给high下标位置，high下标位置元素已经与基准数对比过了
                    s[high] = s[low];
                    // high下标前移
                    high--;
                } else {
                    // 没有找到比基准数小的元素
                    // 说明low位置左边元素都不大于基准数
                    break;
                }
            }
            // low下标赋值基准数
            s[low] = key;
            this.quickSort(left, low - 1);
            this.quickSort(low + 1, right);
        }
    }

    private void display() {
        this.quickSort(0, this.n - 1);
        for (int i = 0; i < this.n; i ++) {
            System.out.println(this.s[i]);
        }
    }

    public static void main(String[] args) {
        N1018 n = new N1018();
        n.display();
    }
}

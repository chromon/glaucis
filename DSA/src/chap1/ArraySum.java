package chap1;

/*
    O(n)

 * Created by Ellery on 2016/11/21.
 */
public class ArraySum {

    private int sum(int[] a) {

        int s = 0;
        for (int i = 0; i < a.length; i ++) {
            s += a[i];
        }

        return s;
    }

    // 数组求和，二分递归 O(n)
    private int sum2(int[] a, int lo, int hi) {
        if (lo == hi) {
            return a[lo];
        }

        int mi = (lo + hi) >> 1;

        return sum2(a, lo, mi) + sum2(a, mi + 1, hi);
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        ArraySum s = new ArraySum();
//        System.out.println(s.sum(a));
        System.out.println(s.sum2(a, 0, a.length - 1));
    }
}

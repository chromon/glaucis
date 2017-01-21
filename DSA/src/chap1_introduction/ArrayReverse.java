package chap1_introduction;

/*
 * Created by Ellery on 2016/11/22.
 */

public class ArrayReverse {

    public void reverse(int[] a, int lo, int hi) {
        if (lo < hi) {
            a[lo] = a[lo] + a[hi];
            a[hi] = a[lo] - a[hi];
            a[lo] = a[lo] - a[hi];

            reverse(a, lo + 1, hi - 1);
        }
    }

    public void reverse2(int[] a, int lo, int hi) {
        while (lo < hi) {
            a[lo] = a[lo] + a[hi];
            a[hi] = a[lo] - a[hi];
            a[lo] = a[lo] - a[hi];

            lo ++;
            hi --;
        }
    }

    public static void main(String[] args) {
        ArrayReverse r = new ArrayReverse();
        int[] a = {1, 2, 3, 4, 5, 6};
        r.reverse2(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i ++) {
            System.out.println(a[i]);
        }
    }
}

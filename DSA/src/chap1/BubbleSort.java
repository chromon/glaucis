package chap1;

/*
    O(n^2)

 * Created by Ellery on 2016/11/21.
 */

public class BubbleSort {

    private int[] bubbleSort(int[] a) {

        int n = a.length;

        for (boolean sorted = false; sorted = !sorted; n --) {
            for (int i = 1; i < n; i ++) {
                if (a[i - 1] > a[i]) {

                    a[i - 1] = a[i - 1] + a[i];
                    a[i] = a[i - 1] - a[i];
                    a[i - 1] = a[i - 1] - a[i];

                    sorted = false;
                }
            }
        }

        return a;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] a = {1, 3, 2, 5, 4};
        b.bubbleSort(a);
        for (int i = 0; i < a.length; i ++) {
            System.out.println(a[i]);
        }
    }
}

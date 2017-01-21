package chap8_hash;

/**
 * 桶、计数排序
 * Created by Ellery on 2017/1/20.
 */


public class CountSort {

    public static int[] countingSort(int[] t) {

        int[] accum = new int[t.length];

        int max = t[0], min = t[0];

        // 最大值，最小值
        for (int i = 0; i < t.length; i ++) {
            if (max < t[i]) {
                max = t[i];
            }
            if (t[i] < min) {
                min = t[i];
            }
        }

        int k = max - min + 1;

        int[] count = new int[k];

        for (int i = 0; i < t.length; i ++) {
            count[t[i] - min] += 1;
        }

        for (int i = 1; i < count.length; i ++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = t.length - 1; 0 <= i; i --) {
            accum[--count[t[i]-min]] = t[i];
        }

        return accum;
    }

    public static void main(String[] args) {
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = CountSort.countingSort(a);
        for(int i: b){
            System.out.print(i + " ");
        }
    }
}

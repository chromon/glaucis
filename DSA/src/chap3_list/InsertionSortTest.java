package chap3_list;

import java.util.Arrays;

/**
 * 插入排序 O(n^2)
 * Created by Ellery on 2016/11/30.
 */
public class InsertionSortTest {

    private static void insertionSort(int[] a) {

        for (int i = 1; i < a.length; i ++) {
            for (int j = i; 0 < j; j --) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] _elem = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        InsertionSortTest.insertionSort(_elem);
        System.out.println(Arrays.toString(_elem));
    }
}

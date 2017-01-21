package chap3_list;

import java.util.Arrays;

/**
 * 选择排序 O(n^2)
 * Created by Ellery on 2016/11/30.
 */
public class SelectionSortTest {

    private static void selectionSortDESC(int[] a) {
        for (int i = 0; i < a.length; i ++) {
            int max = a[i];
            int index = i;
            int temp;

            for (int j = i + 1; j < a.length; j ++) {
                if (a[j] > max) {
                    max = a[j];
                    index = j;
                }
            }

            temp = a[i];
            a[i] = max;
            a[index] = temp;
        }
    }

    private static void selectionSortASC(int[] a) {
        for (int i = a.length - 1; 0 <= i; i --) {
            int max = a[i];
            int index = i;
            int temp;

            for (int j = i - 1; 0 <= j; j --) {
                if (a[j] > max) {
                    max = a[j];
                    index = j;
                }
            }

            temp = a[i];
            a[i] = max;
            a[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] _elem = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};

        SelectionSortTest.selectionSortASC(_elem);
        System.out.println(Arrays.toString(_elem));
    }
}

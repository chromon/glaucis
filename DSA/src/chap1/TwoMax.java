package chap1;

/*
    最小的比较次数找出最大和次大的树

 * Created by Ellery on 2016/11/22.
 */

import java.util.ArrayList;
import java.util.List;

public class TwoMax {

    private List getTwoMax(int[] a, int lo, int hi) {

        int x1 = lo, x2 = lo + 1;
        if(a[x1] < a[x2]) {
            x1 = x1 + x2;
            x2 = x1 - x2;
            x1 = x1 - x2;
        }

        for (int i = lo + 2; i <= hi; i ++) {
            if (a[x2] < a[i]) {
                x2 = i;
                if (a[x1] < a[x2]) {
                    x1 = x1 + x2;
                    x2 = x1 - x2;
                    x1 = x1 - x2;
                }
            }
        }

        List x = new ArrayList();
        x.add(x1);
        x.add(x2);

        return x;
    }

    public static void main(String[] args) {
        TwoMax t = new TwoMax();
        int[] a = {1, 2, 3, 4, 5, 6};
        List x = t.getTwoMax(a, 0, a.length - 1);
        for (Object i : x) {
            System.out.println((int)i);
        }
    }
}

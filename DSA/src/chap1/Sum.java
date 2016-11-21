package chap1;

/*

    O(n)

 * Created by Ellery on 2016/11/21.
 */
public class Sum {

    private int sum(int[] a) {

        int s = 0;
        for (int i = 0; i < a.length; i ++) {
            s += a[i];
        }

        return s;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        Sum s = new Sum();
        System.out.println(s.sum(a));
    }
}

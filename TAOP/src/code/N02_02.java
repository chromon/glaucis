package code;

/**
 * 寻找和为定值的两个数
 *      输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 *
 * Created by Ellery on 2017/2/24.
 */

public class N02_02 {

    private void presetSum(int[] a, int sum) {
        for (int i = 0; i < a.length; i ++) {
            for (int j = 0; j < a.length; j ++) {
                if (a[i] + a[j] == sum) {
                    System.out.println(a[i] + " " + a[j]);
                }
            }
        }
    }

    private void presetSum2(int[] a, int sum) {

        for (int i = 0, j = a.length - 1; i < j;) {
            if (a[i] + a[j] > sum) {
                j --;
            } else if (a[i] + a[j] < sum) {
                i ++;
            } else {
                System.out.println(a[i] + " " + a[j]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        N02_02 n = new N02_02();
        int[] a = {1, 2, 4, 7, 11, 15};
        n.presetSum2(a, 15);
    }
}

package code;

/**
 * 实现string到double的转换
 *
 * Created by Ellery on 2017/2/20.
 */

public class N01_03E {

    public double strToDouble(String s) {

        String[] divideS = s.split("\\.");

        char[] intC = divideS[0].toCharArray();
        char[] deciC = divideS[1].toCharArray();

        double sum = 0;
        for (int i = 0; i < intC.length; i ++) {
            sum  = sum * 10 + Character.getNumericValue(intC[i]);
        }

        double sum2 = 0;
        for (int j = deciC.length - 1; j >= 0; j --) {
            sum2 = sum2 / 10.0 + Character.getNumericValue(deciC[j]) / 10.0;
        }

        return sum + sum2;
    }

    public static void main(String[] args) {
        N01_03E n = new N01_03E();
        System.out.println(n.strToDouble("1234.5678"));
    }
}

import java.math.BigDecimal;

/*
 * Created by Ellery on 2016/11/8.
 */
public class Test {

    public static void main(String[] args) {

        BigDecimal sum = new BigDecimal("1");
        for(int i=2;i<=100000;i++){
            sum = sum.multiply(new BigDecimal(String.valueOf(i)));
        }
        System.out.println(sum.toString().length());
        System.out.println(sum.toString());
    }
}

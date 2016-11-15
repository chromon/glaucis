package basic;

/*
    1011: 最大公约数GCD
    输入2个正整数A，B，求A与B的最大公约数。

    Input
    2个数A,B，中间用空格隔开。(1<= A,B <= 10^9)

    Output
    输出A与B的最大公约数。

    Input 示例
    30 105

    Output 示例
    15

    Created by Ellery on 2016/11/15.
 */

/*
    欧几里德算法:

        假设我们的最大公约数表示为 f(a, b)，并且有 a >= b > 0，欧几里德定理，f(a, b) = f(b, a%b)
 */

import java.io.BufferedInputStream;
import java.util.Scanner;

public class N1011 {

    private int a, b;

    private N1011() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.a = scanner.nextInt();
        this.b = scanner.nextInt();
    }

//    private int oujilide(int a, int b) {
//
//        if (a < b) {
//            a = a + b;
//            b = a - b;
//            a = a - b;
//        }
//
//        if (b == 0) {
//            return a;
//        }
//
//        return oujilide(b, a % b);
//    }

    private int oujilideV2(int a, int b) {

        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        if (b == 0) {
            return a;
        }

        return oujilideV2(a - b, b);
    }

    /*
        若x，y均为偶数，f(x, y) = 2 * f( x / 2, y / 2) = 2 * f( x >> 1, y >> 1);
        若x是偶数，y是奇数，f(x, y) = f(x / 2, y) = f( x >> 1, y);
        若x是奇数，y是偶数，f(x, y) = f(x, y / 2) = f(x, y >> 1);
        若x和y均为奇数，f(x, y) = f(y, x - y)。这时 x - y 一定是偶数，下一步一定会除以2。
     */

//    private int oujilideV3(int a, int b) {
//
//        if (a < b) {
//            oujilideV3(b, a);
//        }
//
//        if (b == 0) {
//            return a;
//        }
//
//        if (isEven(a)) {
//            if (isEven(b)) {
//                return oujilideV3(a / 2, b / 2) * 2;
//            }
//            return oujilideV3(a / 2, b);
//        } else {
//            if (isEven(b)) {
//                return oujilideV3(a, b / 2);
//            }
//            return oujilideV3(b, a - b);
//        }
//    }
//
//    private boolean isEven(int a) {
//        if (a % 2 == 0) {
//            return true;
//        }
//        return false;
//    }

    private void display() {
//        System.out.println(oujilide(this.a, this.b));
        System.out.println(oujilideV2(this.a, this.b));
//        System.out.println(oujilideV3(this.a, this.b));
    }

    public static void main(String[] args) {
        N1011 n = new N1011();
        n.display();
    }
}

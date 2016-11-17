package basic;

/*
    1012: 最小公倍数LCM
    输入2个正整数A，B，求A与B的最小公倍数。

    Input
    2个数A,B，中间用空格隔开。(1<= A,B <= 10^9)

    Output
    输出A与B的最小公倍数。

    Input 示例
    30 105

    Output 示例
    210

    Created by Ellery on 2016/11/16.
 */


import java.io.BufferedInputStream;
import java.util.Scanner;

public class N1012 {

    private long a, b;

    public N1012() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.a = scanner.nextLong();
        this.b = scanner.nextLong();
    }

    private long gcd(long a, long b) {

        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        if (b == 0) {
            return a;
        }

        return gcd(a - b, b);
    }

    private long lcm() {
//        System.out.prlongln(this.gcd(this.a, this.b));
//        System.out.prlongln(this.a * this.b / this.gcd(this.a, this.b));
        return this.a * this.b / this.gcd(this.a, this.b);
    }

    private void display() {
        System.out.print(this.lcm());
    }

    public static void main(String[] args) {
        N1012 n = new N1012();
        n.display();
    }
}

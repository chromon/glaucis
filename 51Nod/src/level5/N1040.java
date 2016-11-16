package level5;

/*
    1040: 最大公约数之和
    给出一个n，求1-n这n个数，同n的最大公约数的和。
    比如：n = 6； 1，2，3，4，5，6 同6的最大公约数分别为1，2，3，2，1，6，加在一起 = 15

    Input
    1个数N(N <= 10^9)

    Output
    公约数之和

    Input 示例
    6

    Output 示例
    15

    Created by Ellery on 2016/11/15.
 */

/*
    欧几里德算法:

        假设我们的最大公约数表示为 f(a, b)，并且有 a >= b > 0，欧几里德定理，f(a, b) = f(b, a%b)
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class N1040 {

    private long n;

    private PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private N1040() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.n = scanner.nextInt();
    }

    private long eular(long x) {

        long i, res = x;
        for (i = 2; i < (int) Math.sqrt(x * 1.0) + 1; i ++) {
            if (x % i == 0) {
                res = res / i * (i - 1);
                while (x % i == 0) {
                    // 保证i一定是素数
                    x /= i;
                }
            }
        }
        if (x > 1) {
            res = res / x * (x - 1);
        }
        return res;
    }

    private void display() {
        long sum = 0;

        for (long i = 1; i * i <= this.n; i++) {
            if (this.n % i == 0) {
                long tmp = this.n / i;
                sum += this.eular(tmp) * i;

                if (i != tmp) {
                    sum += this.eular(i) * tmp;
                }
            }
        }

        out.println(sum);
        out.flush();
    }

    public static void main(String[] args) {
        N1040 n = new N1040();
        n.display();
    }
}

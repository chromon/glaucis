package basic;

/*
1046: A^B Mod C

给出3个正整数A B C，求A^B Mod C。

例如，3 5 8，3^5 Mod 8 = 3。

Input

3个正整数A B C，中间用空格分隔。(1 <= A,B,C <= 10^9)

Output

输出计算结果

Input 示例

3 5 8

Output 示例

3

Created by Ellery on 2017/1/8.
 */


import java.io.BufferedInputStream;
import java.util.Scanner;

public class N1046 {

    private long a, b, c;

    private N1046() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        this.a = scanner.nextLong();
        this.b = scanner.nextLong();
        this.c = scanner.nextLong();
    }

    private void modeXp() {
        // 公式 a * b % c = (( a % c) * b) % c
        long ret = 1;
        while (this.b -- != 0) {
            ret = this.a * ret % this.c;
        }
        System.out.println(ret);
    }

    private long power(long a, long N, long mod) {
        long result = 1;
        while(N > 0){
            if(N % 2 == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            N /= 2;
        }
        return result;
    }

    private void display() {
        System.out.println(this.power(this.a, this.b, this.c));
    }

    public static void main(String[] args) {
        N1046 n = new N1046();
//        n.modeXp();
        n.display();
    }
}

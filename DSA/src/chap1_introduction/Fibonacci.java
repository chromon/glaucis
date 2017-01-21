package chap1_introduction;

/*
 * Created by Ellery on 2016/11/22.
 */

public class Fibonacci {

    // 二分递归 O(2^n)
    private int fib(int n) {
        return (n < 2) ? n: fib(n - 1) + fib(n - 2);
    }

    // 迭代
    private int fib2(int n) {
        int f = 0;
        int g = 1;

        while (0 < n --) {
            g = g + f;
            f = g - f;
        }
        return f;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
//        System.out.println(f.fib(5)); 0 1 1 2 3 5 8
        System.out.println(f.fib2(5));
    }
}

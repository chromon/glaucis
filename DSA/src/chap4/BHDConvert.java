package chap4;

/**
 * 进制转换
 * Created by Ellery on 2016/12/1.
 */

public class BHDConvert {

    private static Character[] digit = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static void convert(MyStack<Character> s, int n, int base) {
        while (0 < n) {
            s.push(digit[n % base]);
            n /= base;
        }
    }

    public static void main(String[] args) {
        MyStack<Character> s = new MyStack<>(Character.class);
        BHDConvert.convert(s, 2013, 16);
        for (int i = s.size(); 0 < i; i --) {
            System.out.print(s.pop());
        }
    }
}

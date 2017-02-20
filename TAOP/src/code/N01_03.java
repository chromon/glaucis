package code;

/**
 * 输入一个由数字组成的字符串，把它转换成整数并输出。例如：输入字符串"123"，输出整数123。
 * 给定函数原型int StrToInt(const char *str) ，实现字符串转换成整数的功能，不能使用库函数atoi。
 *
 * Created by Ellery on 2017/2/19.
 */

public class N01_03 {

    public int strToInt(String a) {

        char[] ca = a.toCharArray();

        int sum = 0;
        for (int i = 0; i < ca.length; i ++) {
            sum = sum * 10 + Character.getNumericValue(ca[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        N01_03 n = new N01_03();
        System.out.println(n.strToInt("123456"));
    }
}

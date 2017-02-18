package code;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 0101 练习题
 *
 * Created by Ellery on 2017/2/18.
 */

public class N01_01E {

    /**
     * 字符翻转
     * @param c 待翻转字符数组
     * @param lo 起始位置
     * @param hi 结束位置
     */
    private void reverseString(char[] c, int lo, int hi) {
        while (lo < hi) {
            char t = c[lo];
            c[lo] = c[hi];
            c[hi] = t;

            lo ++;
            hi --;
        }
    }

    private void reverseString(String[] c, int lo, int hi) {
        while (lo < hi) {
            String t = c[lo];
            c[lo] = c[hi];
            c[hi] = t;

            lo ++;
            hi --;
        }
    }

    /**
     * 1. 链表翻转。
     *      给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，
     *      若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现
     * @param s
     * @param n
     * @return
     */
    private String reverseLinkList(String s, int n) {

        char[] c = s.toCharArray();

        this.reverseString(c, 0, n - 1);
        this.reverseString(c, n, c.length - 1);

        return String.valueOf(c);
    }

    /**
     * 2. 编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，
     *      要求：长度为n的字符串操作时间复杂度为 O(n)，空间复杂度为 O(1)。
     *      例如，原字符串为 “Ilovebaofeng” ，m=7，输出结果为：“baofengIlove”。
     *
     *      相当于字符翻转的变种，m 个尾字符相当于 （s.length - m） 个头字符移动到尾部
     * @param s
     * @param m
     * @return
     */
    private String reverseStringFromTail(String s, int m) {

        char[] c = s.toCharArray();
        int n = c.length - m;
        this.reverseString(c, 0, n - 1);
        this.reverseString(c, n, c.length - 1);
        this.reverseString(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    /**
     * 3. 单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
     * 为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
     * @param s
     * @return
     */
    private String reverseSentence(String s) {

        String[] wordStr = s.split(" ");

        this.reverseString(wordStr, 0, wordStr.length - 1);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < wordStr.length; i ++) {
            sb.append(wordStr[i] + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        N01_01E ne = new N01_01E();
        System.out.println(ne.reverseLinkList("123456", 2));
        System.out.println(ne.reverseStringFromTail("Ilovebaofeng", 7));
        System.out.println(ne.reverseSentence("I am a student."));
    }
}

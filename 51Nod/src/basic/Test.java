package basic;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

/*
 * Created by Ellery on 2016/11/8.
 */
public class Test {

    public static void main(String[] args) {

        System.out.print(String.format(Locale.getDefault(), "%012d", 1234));
    }
}

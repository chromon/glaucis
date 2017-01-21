package chap4_stack;

/**
 * 括号匹配
 *
 * Created by Ellery on 2016/12/2.
 */

public class Parenthesis {

    /**
     * 判断括号是否匹配 [lo, hi)
     * @param exp 待判别表达式
     * @param lo 起始区间
     * @param hi 结束区间
     * @return 是否匹配
     */
    private static boolean paren(char[] exp, int lo, int hi) {
        MyStack<Character> s = new MyStack<>(Character.class);

        for (int i = lo; i < hi; i ++) {
            if ('(' == exp[i]) {
                s.push(exp[i]);
            } else if (!s.empty()) {
                s.pop();
            } else {
                // 遇到右括号时栈以空，不匹配，缺左括号
                return false;
            }
        }

        // 栈不为空，不匹配，缺右括号，返回 false
        // 栈为空，匹配，返回 true
        return s.empty();
    }

    private static boolean parenMulti(char[] exp, int lo, int hi) {
        MyStack<Character> s = new MyStack<>(Character.class);
        for (int i = lo; i < hi; i ++) {
            switch (exp[i]) {
                case '{': case '[':case '(':
                    s.push(exp[i]);
                    break;
                case ')' :
                    if ((s.empty()) || ('(' != s.pop())) {
                        return false;
                    }
                    break;
                case ']' :
                    if ((s.empty()) || ('[' != s.pop())) {
                        return false;
                    }
                    break;
                case '}' :
                    if ((s.empty()) || ('{' != s.pop())) {
                        return false;
                    }
                    break;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        // 待判别表达式，简化无关内容
        char[] exp = {'(', '(', ')', '(', '(', ')', ')', '(', ')', ')'};
        System.out.println(Parenthesis.paren(exp, 0, exp.length));

        char[] exp2 = {'{', '(', ')', '[', '(', '{', '}', ')', ']', '}'};
        System.out.println(Parenthesis.parenMulti(exp2, 0, exp.length));
    }
}

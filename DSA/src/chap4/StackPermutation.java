package chap4;

/**
 * 栈混洗
 *      总数等于卡特兰数 sp(n) = catalan(n) = (2n)!/(n + 1)!*n!
 *
 *  <1, 2, 3] 的栈混洗总数为 5，而 3！ = 6，不存在的是 [3, 1, 2>
 *  所以，任意三个元素能否按照某相对次序出现在栈混洗中，与其他元素无关
 *
 *  结论，对于任意的 1 < i < j < k < n, [..., k, ..., i, ..., j, ...> 一定不是栈混洗（充要条件）
 *
 * Created by Ellery on 2016/12/2.
 */

/**
 *  B [3, 2, 4, 1>  S   <1, 2, 3, 4] A
 *  判断 A 栈混洗能否出现 B 情况
 */
public class StackPermutation {

    private MyStack<Integer> a  = new MyStack<>(Integer.class);
    private MyStack<Integer> s  = new MyStack<>(Integer.class);
    private MyStack<Integer> b  = new MyStack<>(Integer.class);

    private String[] operate;

    /**
     * B [3, 2, 4, 1>  S   <1, 2, 3, 4] A
     *      判断 A 经由栈混洗能否出现 B 情况
     *      push A - S, pop S - B
     * @param n 初始栈长度（即栈 A 元素从 1 ~ n）
     * @param bb 需要判断的结果序列，内容为由栈底（0）到栈顶（n - 1） [...>
     */
    public void permute(int n, int[] bb) {

        this.operate = new String[2 * n];
        int k = 0;

        // 初始化 A <1, 2, 3..., n]
        for (int i = n; 0 < i; i --) {
            a.push(i);
        }

        // 循环栈 B 的可能结果
        for (int i = 1; i <= n; i ++) {

            if (!s.empty() && (s.top() == bb[i - 1])) {
                // S 栈顶与 B 的目标栈匹配
                b.push(s.pop());
                this.operate[k ++] = "pop";
            } else if (!a.empty() && (a.top() == bb[i - 1])) {
                // A 的栈顶与 B 的目标栈匹配
                b.push(a.pop());
                this.operate[k ++] = "push";
                this.operate[k ++] = "pop";
            } else {
                s.push(a.pop());
                this.operate[k ++] = "push";
                // A S 均不与 B 匹配
                i --;
                if(a.empty()) {
                    break;
                }
            }
        }

        String s1 = "", s2 = "";

        // 目标结果
        System.out.print("target:");
        for (int i = bb.length - 1; 0 <= i; i --) {
            s1 += bb[i];
            System.out.print(bb[i]);
        }
        System.out.println();

        // 实际结果
        System.out.print("result:");
        for (int i = b.size(); 0 < i; i --) {
            s2 += b.top();
            System.out.print(b.pop());
        }
        System.out.println();

        // 是否匹配
        if (s1.equals(s2)) {
            System.out.println("mapping");
            for (int i = 0; i < k; i ++) {
                System.out.print(this.operate[i] + " ");
            }
        } else {
            System.out.println("not mapping");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] bb = {3, 2, 4, 1};

        StackPermutation sp = new StackPermutation();
        sp.permute(n, bb);
    }
}

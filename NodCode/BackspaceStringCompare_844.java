class Solution {
    public boolean backspaceCompare(String S, String T) {
        
        Stack<Character> ss = new Stack<>();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (ss.size() > 0) {
                    ss.pop();
                }
            } else {
                ss.push(S.charAt(i));
            }
        }
        
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (st.size() > 0) {
                    st.pop();
                }
            } else {
                st.push(T.charAt(i));
            }
        }
        
        if (ss.size() != st.size()) {
            return false;
        } else {
            while (!ss.empty() && !st.empty()) {
                if (ss.pop() != st.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
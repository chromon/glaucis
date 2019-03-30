class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (String op: ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int tmp = top + stack.peek();
                stack.push(top);
                stack.push(tmp);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        return sum;
    }
}
class MinStack {
    
    Stack<Integer> data;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        
        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (min.peek() > x) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }
    }
    
    public void pop() {
        min.pop();
        data.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
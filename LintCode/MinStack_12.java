public class MinStack {
    
    Stack<Integer> data;
    Stack<Integer> min;
    
    public MinStack() {
        // do intialization if necessary
        data = new Stack();
        min = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        data.push(number);
        if (min.isEmpty()) {
            min.push(number);
        } else {
            if (min.peek() > number) {
                min.push(number);
            } else {
                min.push(min.peek());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        min.pop();
        return data.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min.peek();
    }
}
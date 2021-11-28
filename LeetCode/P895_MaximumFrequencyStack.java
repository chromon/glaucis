/*
895. Maximum Frequency Stack
Hard

Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 

Constraints:

0 <= val <= 109
At most 2 * 104 calls will be made to push and pop.
It is guaranteed that there will be at least one element in the stack before calling pop.
*/

class FreqStack {
    
    // 记录 FreqStack 中元素的最大频率
    int maxFreq;
    // 记录 FreqStack 中每个 val 对应的出现频率
    HashMap<Integer, Integer> vf;
    // 记录频率 freq 对应的 val 列表
    HashMap<Integer, Stack<Integer>> fvs;

    public FreqStack() {
        maxFreq = 0;
        vf = new HashMap<>();
        fvs = new HashMap<>();
    }
    
    public void push(int val) {
        // val 对应的 freq 加一
        int freq = vf.getOrDefault(val, 0) + 1;
        vf.put(val, freq);
        
        // 在 freq 对应的列表加上 val
        fvs.putIfAbsent(freq, new Stack<>());
        fvs.get(freq).push(val);
        
        // 更新 maxFreq
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        // pop maxFreq 对应的元素 v
        Stack<Integer> vals = fvs.get(maxFreq);
        int v = vals.pop();
        
        // v 对应的 freq 减一
        int freq = vf.get(v) - 1;
        vf.put(v, freq);
        
        // 更新 maxFreq
        if (vals.isEmpty()) {
            // 如果 maxFreq 对应的元素空了
            maxFreq--;
        }
        return v;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
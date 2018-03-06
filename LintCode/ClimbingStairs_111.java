public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
     
    /*
     public int climbStairs(int n) {
        // write your code here
        
        if(n <= 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(n == 2) {
            return 2;
        }
        
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    */
    
    
    /*
    Map<Integer, Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        // write your code here
        
        if(n <= 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(n == 2) {
            return 2;
        }
        
        if(map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, value);
            return value;
        }
    }
    */
    
    public int climbStairs(int n) {
        // write your code here
    
        if(n <= 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        if(n == 2) {
            return 2;
        }
        
        int a = 1;
        int b = 2;
        int tmp = 0;
        
        for(int i = 3; i <= n; i ++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        
        return tmp;
    }
}
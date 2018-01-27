public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        if(a==0) return b;  //不再进位  
        if(b==0) return a;  //不进位操作为零，直接取进位操作的结果  
        int sum,i;    
        i=a^b; //不进位相加的结果   
        sum=(a&b)<<1;  //进位的结果  
        return aplusb(sum,i); // 两者再进行相加 
    }
}
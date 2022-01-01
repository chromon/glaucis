/*
1287. Element Appearing More Than 25% In Sorted Array
Easy
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Example 2:

Input: arr = [1,1]
Output: 1
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 105
*/

class Solution {
    /*
    public int findSpecialInteger(int[] arr) {
        
        int count = 0;
        int max = -1;
        int maxVal = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            count++;
            
            if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
                if (count > maxVal) {
                    maxVal = count;
                    max = arr[i];
                }
                
                count = 0;
            }
        }
        
        return max;  
    }
    */
    
    public int findSpecialInteger(int[] arr) {
        int n = arr.length / 4;
        
        for (int i = 0; i < arr.length - n; i++) {
            if (arr[i] == arr[i + n])
                return arr[i];
        }
        
        return -1;
    }
}
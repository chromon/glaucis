class Solution {
    public int thirdMax(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] > nums[1]? nums[0]: nums[1];
        }
        
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3 = Integer.MIN_VALUE;
        
        boolean hasMin = false;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (!hasMin && nums[i] == Integer.MIN_VALUE) {
                hasMin = true;
            }
            
            if (nums[i] > n1) {
                n3 = n2;
                n2 = n1;
                n1 = nums[i];
            } else if (nums[i] == n1 || nums[i] == n2 || nums[i] == n3) {
                continue;
            } else if (nums[i] > n2) {
                n3 = n2;
                n2 = nums[i];
            } else if (nums[i] > n3) {
                n3 = nums[i];
            }
        }
        
        if (n3 == Integer.MIN_VALUE) {    
            if (n2 == Integer.MIN_VALUE) {
                return n1;
            } else {
                if (hasMin) {
                    return n3;
                } else {
                    return n1;
                }
            }
        }
        
        return n3;
    }
}
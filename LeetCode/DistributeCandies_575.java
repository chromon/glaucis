class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> nums = new HashSet<>();
        
        for (int i=0; i < candies.length; i++) {
            nums.add(candies[i]);
        }
        
        int numNums = nums.size();
        int numTarget = candies.length / 2;
        
        return numNums >= numTarget ? numTarget : numNums;
    }
}
public class Solution {
    /**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) 
            return -1;
            
        int len = gas.length;
        int[] val = new int[len * 2];
        for (int i = 0; i < len; ++i) {
            val[i] = gas[i] - cost[i];
            val[i + len] = val[i];
        }
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            if (val[i] <= 0) continue;
            sum = val[i];
            for (int j = i + 1; j < i + len; ++j) {
                sum += val[j];
                if (sum < 0) break;
            }
            if (sum >= 0) return i;
        }
        return -1; 
    }
}
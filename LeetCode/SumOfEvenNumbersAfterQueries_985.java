class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i : A) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            
            A[index] += val;
            
            if (A[index] % 2 == 0) {
                sum += A[index];
            }
            
            list.add(sum);
        }
        
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        
        return res;
    }
}
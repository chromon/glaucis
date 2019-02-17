public class Solution {
    
    int[] subfun(int[] A,int [] B, int len) {
        int[] ans = new int[len];
        for(int i = 0; i * 2 + 1 < len; i++) {
            ans[i * 2] = A[i];
            ans[i * 2 + 1] = B[i];
            }
        if(len % 2 == 1)
            ans[len - 1] = A[len / 2];
        return ans;
    }
    
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        int[] Ap = new int[A.length];
        int totp = 0;
        int totm = 0;
        int[] Am = new int[A.length];
        int[] tmp = new int[A.length];
        for(int i = 0; i < A.length; i++)
            if(A[i] > 0)
                {
                    Ap[totp] = A[i];
                    totp += 1;
                }
            else
                {
                    Am[totm] = A[i];
                    totm += 1;  
                }   
        if(totp > totm)
            tmp = subfun(Ap, Am, A.length);
        else
            tmp = subfun(Am, Ap, A.length);
        for (int i = 0; i < tmp.length; ++i)
            A[i] = tmp[i];
    }
}
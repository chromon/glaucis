public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(0, A.length - 1, A);
    }
    
    public void quickSort(int lo, int hi, int[] A) {
        if (hi - lo >= 1) {
            int mi = partition(lo, hi, A);
            quickSort(lo, mi, A);
            quickSort(mi + 1, hi, A);
        }
    }
    
    private int partition(int lo, int hi, int[] A) {
        //任选一个元素与首元素交换
        int pivot = A[lo];

        // 从两端交替向中间扫描
        while(lo < hi) {

            // 不小于轴点
            while((lo < hi) && (pivot <= A[hi])) {
                // 向左扩展右端的子向量
                hi --;
            }
            // 小于轴点的放入左边子向量空闲位置
            A[lo] = A[hi];

            // 不大于轴点
            while(( lo < hi) && (A[lo] <= pivot)) {
                lo ++;
            }
            // 大于轴点的放入右边子向量空闲位置
            A[hi] = A[lo];
        }

        // 将备份的轴点放入左右子向量中间
        A[lo] = pivot;

        // 返回轴点的秩
        return lo;
    }
}
/*
215. Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*/

class Solution {
    
    public int findKthLargest(int[] nums, int k) {
    	return quickSort(nums, 0, nums.length - 1, k);
    }
    
    // 递归寻找数组中第 K 大的元素
    private int quickSort(int[] a, int low, int high, int K) {
    	int pivot = partition(a, low, high);

    	if(pivot < K - 1) {         // 中轴位置少于 K 个，在右子数组中继续查找
    		return quickSort(a, pivot + 1, high, K);
        } else if(pivot > K - 1) {  // 中轴位置大于 K 个，在左子数组中继续查找
    		return quickSort(a, low, pivot-1, K);
        } else {                    // 中轴元素正好是第K大的元素
    		return a[pivot];
        }
    }
    
    // 将数组划分为两部分，左边较大，右边较小
	private int partition(int[] a, int low, int high) {
		// 将数组首元素作为每一轮比较的基准
		int pivotValue = a[low];

		while (low < high) {
			// 从右往左扫描，直到遇到比基准元素小的元素
			while (low < high && a[high] <= pivotValue) {
                --high;
            }

			// 将右子数组中不合格的元素放到左边不合格元素的位置（原元素已经移走）
			a[low] = a[high];

			// 从左往右扫描，直到遇到比基准元素大的元素
			while (low < high && a[low] >= pivotValue) {
                ++low;
            }
            
			// 将左子数组中不合格的元素放到左边不合格元素的位置（原元素已经移走）
			a[high] = a[low];
		}

		// 将基准元素放到中间位置
		a[low] = pivotValue;

		// 返回数组的中轴位置
		return low;
	}
}
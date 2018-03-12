public class Solution {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        
        List<Integer> list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        List<Integer> reList = new ArrayList<>();
        
        for(int i = list.size() - 1; i >= 0; i --) {
            reList.add(list.get(i));
        }
        
        return reList;
    }
}
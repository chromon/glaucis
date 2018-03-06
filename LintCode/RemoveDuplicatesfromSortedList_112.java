/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        
        Map<Integer, Integer> map = new HashMap<>();
        ListNode t = new ListNode(0);
        t.next = head;
        
        while(t.next != null) {
            if(! map.containsKey(t.next.val)) {
                map.put(t.next.val, t.next.val);
                t = t.next;
            } else {
                t.next = t.next.next;
            }
        }
        
        return head;
    }
}
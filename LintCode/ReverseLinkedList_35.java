/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        
        if(head == null) {
            return null;
        }
        
        ListNode tmp;
        ListNode newHead = new ListNode(0);
        
        while(head != null) {
            tmp = new ListNode(0);
            tmp.val = head.val;
            tmp.next = newHead.next;
            newHead.next = tmp;
            head = head.next;
        }
        
        newHead.val = newHead.next.val;
        newHead.next = newHead.next.next;
        
        return newHead;
    }
}
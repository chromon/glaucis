/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        
        if(head == null) {
            return null;
        }
        
        while(head.val == val) {
            head = head.next;
            if(head == null) {
                return null;
            }
        }
        
        ListNode tmpHead = head;
        
        while(tmpHead.next != null) {
            if(tmpHead.next.val == val) {
                tmpHead.next = tmpHead.next.next;
            } else {
                tmpHead = tmpHead.next;
            }
        }
        
        return head;
    }
}
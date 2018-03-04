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
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        
        if(head == null) {
            return null;
        }
        
        ListNode s = new ListNode(x);
        ListNode l = new ListNode(x);
        
        ListNode t1 = s;
        ListNode t2 = l;
        
        while(head != null) {
            if(head.val < x) {
                s.next = head;
                head = head.next;
                s = s.next;
            } else {
                l.next = head;
                head = head.next;
                l = l.next;
            }
        }
        
        s.next = t2.next;
        l.next = null;
     
        return t1.next;   
    }
}
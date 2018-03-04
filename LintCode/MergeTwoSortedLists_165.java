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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode l = new ListNode(0);
        ListNode t = l;
        
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                t.next = l2;
                t = t.next;
                l2 = l2.next;
            } else {
                t.next = l1;
                t = t.next;
                l1 = l1.next;
            }
        }
        
        if(l1 != null) {
            t.next = l1;
        }
        
        if(l2 != null) {
            t.next = l2;
        }
        
        return l.next;
    }
}
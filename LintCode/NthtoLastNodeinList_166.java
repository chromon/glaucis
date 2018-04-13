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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head == null) {
            return null;
        }
        
        ListNode l1 = head;
        ListNode l2 = head;
        
        int t = 1;
        while(t < n) {
            l2 = l2.next;
            t ++;
        }
        
        while(l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1;
    }
}
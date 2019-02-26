/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l;
        ListNode l0 = new ListNode(0);
        l = l0;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l0.next = l1;
                l0 = l0.next;
                l1 = l1.next;
            } else {
                l0.next = l2;
                l0 = l0.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null) {
            l0.next = l1;
        } else if (l2 != null) {
            l0.next = l2;
        }
        
        return l.next;
    }
}
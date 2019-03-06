/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        ListNode node = new ListNode(0);
        ListNode tmp;
        
        while (head != null) {
            tmp = new ListNode(head.val);
            tmp.next = node.next;
            node.next = tmp;
            
            head = head.next;
        }
        
        return node.next;
    }
}
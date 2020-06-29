/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        
        while (l1 != null || l2 != null) {
            
            int bit = 0;
            if (l1 != null) {
                bit += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                bit += l2.val;
                l2 = l2.next;
            }
            
            bit += carry;
            
            if (bit > 9) {
                bit %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            head.next = new ListNode(bit);
            head = head.next;
        }
        
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        
        return node.next;
    }
}
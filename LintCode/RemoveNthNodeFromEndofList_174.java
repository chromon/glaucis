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
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        ListNode l0 = new ListNode(0);
        l0.next = head;
        ListNode l1 = l0;
        ListNode l2 = head;
        
        int t = 0;
        while(t < n) {
            l2 = l2.next;
            t ++;
        }
        
        while(l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        
        l1.next = l1.next.next;
        return l0.next;
    }
}
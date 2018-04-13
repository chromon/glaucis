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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        
        ListNode res = new ListNode(0);
        
        while(head != null) {
            ListNode t = res;
            
            while(t.next != null && t.next.val < head.val) {
                t = t.next;
            }
            
            ListNode node = new ListNode(head.val);
            node.next = t.next;
            t.next = node;
            
            head = head.next;
        }
        
        return res.next;
    }
}
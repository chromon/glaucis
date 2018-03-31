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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode l = new ListNode(0);
        ListNode r = l;
        ListNode pre = null;
        int t = 0;
        
        while(l1 != null || l2 != null) {
            
            int tmp = 0;
            if(l1 != null && l2 != null) {
                tmp = l1.val + l2.val + t;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null) {
                tmp = l1.val + t;
                l1 = l1.next;
            } else {
                tmp = l2.val + t;
                l2 = l2.next;
            }
            
            t = 0;
            
            if(tmp > 9) {
                tmp %= 10;
                t = 1;
            }
            
            l.val = tmp;
            pre = l;
            l.next = new ListNode(0);
            l = l.next;
        }
        
        if(t > 0) {
            l.val = 1;
        } else {
            pre.next = null;
        }
        
        return r;
    }
}
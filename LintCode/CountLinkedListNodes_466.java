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
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int countNodes(ListNode head) {
        // write your code here
        int count = 0;
        while(head != null) {
            count ++;
            head = head.next;
        } 
        return count;
    }
}
/*
24. Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode node = new ListNode(-1);
        ListNode t = node;
        
        while (head != null && head.next != null) {
            ListNode node1 = head;
            ListNode node2 = head.next;
            
            node.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            node = node1;
            
            head = node1.next;
        }
        
        if (head != null) {
            node.next = head;
        }
        
        return t.next;
    }
}
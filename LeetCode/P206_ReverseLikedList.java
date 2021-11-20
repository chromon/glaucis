/*
206. Reverse Linked List
Easy

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, nxt = null;
        
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    
    /*
    public ListNode reverseList(ListNode head) {
        ListNode cur = new ListNode(0);
        
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = cur.next;
            cur.next = tmp;
            
            head = head.next;
        }
        
        return cur.next;
    }
    */
    
    /*
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    */
}
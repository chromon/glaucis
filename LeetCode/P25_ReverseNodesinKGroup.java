/*
25. Reverse Nodes in k-Group
Hard

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]
 

Constraints:

The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 

Follow-up: Can you solve the problem in O(1) extra memory space?
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
    
    /*
    // 递归反转整个链表（从 head 到 null）
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
    */
    
    // 递归反转 [a, b) 之间的链表
    public ListNode reverseList(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt = null;
        
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;  
        }
        
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        
        // 反转前 k 个元素
        ListNode newHead = reverseList(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    
    
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode list = new ListNode(-1);
        ListNode res = list;
        
        Stack<Integer> stack = new Stack<>();
        
        while (head != null) {
            
            ListNode curr = head;
            
            for (int i = 0; (i < k) && (head != null); i++) {
                stack.push(head.val);
                head = head.next;
            }
            
            if (stack.size() < k) {
                list.next = curr;
                break;
            }
            
            while (!stack.isEmpty()) {
                ListNode node = new ListNode(stack.pop());
                //node.next = list.next;
                list.next = node;
                list = list.next;
            }
        }
        return res.next;
    }
    */
}
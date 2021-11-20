/*
234. Palindrome Linked List
Easy

Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
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
    
    
    public boolean isPalindrome (ListNode head) {
    
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode tail = reverseLinkedList(slow);
        
        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            } 
            
            head = head.next;
            tail = tail.next;
        }
        
        return true;
    }
    
    private ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
            
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        
        return prev;
    }
    
    /*
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode list = head;
        
        while (list != null) {
            stack.push(list.val);
            list = list.next;
        }
        
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }*/
    
    
    /*
    // 链表兼具递归结构，树结构是链表的衍生。所以，链表其实也可以有前序遍历和后序遍历：
    void traverse(ListNode head) {
        // 前序遍历代码
        System.out.println("pre: " + head.val);

        traverse(head.next);

        // 后序遍历代码
        System.out.println("post: " + head.val);
    }  
    */
    
    /*
    // 左侧指针
    ListNode left;
    
    public boolean isPalindrome (ListNode head) {
        left = head;
        return traverse(head);
    }
    
    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
    */
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode n1 = head;
        ListNode n2 = new ListNode(0);
        ListNode tmp;
        int len = 0;
        
        // 链表长度
        while (n1 != null) {
            len++;
            n1 = n1.next;
        }
        
        // 翻转前半部分
        for (int i = 0; i < len / 2; i++) {
            tmp = new ListNode(head.val);
            tmp.next = n2.next;
            n2.next = tmp;

            head = head.next;
        }
        
        // 如果长度为奇数，跳过中间位
        if (len % 2 == 1) {
            head = head.next;
        } 
        
        n2 = n2.next;
        
        while (n2 != null) {
            if (n2.val != head.val) {
                return false;
            } else {
                n2 = n2.next;
                head = head.next;
            }
        }
        
        return true;
    }
}
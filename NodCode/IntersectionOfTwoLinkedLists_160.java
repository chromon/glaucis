/**
 * Definition for singly-linked list.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        /*
        如果两个链表的长度相等，依次比较每个节点是否相等即可。一般的做法是将两个链表的长度设置相等即可。这里利用两次循环和两个指针，第一次将不同的元素略过，第二次如果有相交的元素则返回相交的节点，如果没有，就返回null。如果短的链表已经循环完毕就将指针指向不同的链表的头结点。
     */
        
        if (headA==null || headB == null) {
           return null;
        }
        
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB){
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
        }

        return curA;
    }
}
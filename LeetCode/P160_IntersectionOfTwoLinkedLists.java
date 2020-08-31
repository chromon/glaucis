/*
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

Example 2:

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.
*/

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

/*
这道题的思路其实类似链表找环。

给定的 2 个链表的长度如果一样长，都从头往后扫即可。如果不一样长，需要先“拼成”一样长。
把 B 拼接到 A 后面，把 A 拼接到 B 后面。这样 2 个链表的长度都是 A + B。再依次扫描比较 2 个链表的结点是否相同。
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        
        return a;
    }
}
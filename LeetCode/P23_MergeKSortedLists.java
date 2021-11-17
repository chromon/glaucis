/*
23. Merge k Sorted Lists
Hard

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

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
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode l = head;
        
        if (lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->(a.val - b.val));
        for (ListNode n : lists) {
            if (n != null) {
                pq.add(n);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            l.next = n;
            l = l.next;
            
            if (n.next != null) {
                pq.add(n.next);
            }
        }
        
        return head.next;    
    }
    
    /*
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode l = head;
        
        for (int i = 0; i < lists.length; i++) {
            l = mergeTwoLists(l, lists[i]);
        }
        return head.next;    
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode l = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                l.next = l2;
                l2 = l2.next;
            } else {
                l.next = l1;
                l1 = l1.next;
            }
            l = l.next;
        }
        
        if (l1 != null) {
            l.next = l1;
        }
        
        if (l2 != null) {
            l.next = l2;
        }
        
        return head.next;
    }
    */
}
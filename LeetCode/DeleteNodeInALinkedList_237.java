/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // node 节点就是要被删除的节点，直接覆盖就好了
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
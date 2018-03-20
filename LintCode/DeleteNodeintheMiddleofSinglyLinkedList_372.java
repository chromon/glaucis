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
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        // 给定的是待删除的节点而不是头节点，直接用后一个节点覆盖待删除节点
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
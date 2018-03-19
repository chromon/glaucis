/**
 * Definition for ListNode
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
    /**
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        
        // 待交换两个节点中的第一个
        ListNode tmp = head;
        
        // tmp的前一个节点
        ListNode r = new ListNode(0);
        r.next = head;
        
        // 结果
        ListNode r2 = r;
        
        while(tmp != null) {
            if(tmp.next == null) {
                // 奇数个，跳出
                break;
            }
            
            // 交换两个节点
            ListNode t = tmp.next;
            tmp.next = t.next;
            t.next = tmp;
            
            // r指向交换后的第一个节点
            r.next = t;
            
            // tmp移动到待交换两个节点中的第一个，r重新指向新的待交换节点
            tmp = tmp.next;
            r = r.next.next;
        }
        
        return r2.next;
    }
}
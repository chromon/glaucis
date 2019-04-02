public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) { 
        val = x; 
    }
}

class MyLinkedList {
    
    private ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode tmp = head.next;
        int i = 0;
        
        while(tmp != null && i < index) {
            tmp = tmp.next;
            i++;
        }
        
        if (tmp == null || i > index) {
            return -1;
        }
        
        return tmp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode tmp = head.next;
        
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        
        tmp.next = node;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode tmp = head;
        int i = -1;
        
        while(tmp != null && i < index - 1) {
            tmp = tmp.next;
            i++;
        }
        
        if (tmp != null && i <= index - 1) {
            ListNode node = new ListNode(val);
            node.next = tmp.next;
            tmp.next = node;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode tmp = head;
        int i = -1;
        
        while(tmp != null && i < index - 1) {
            tmp = tmp.next;
            i++;
        }
        
        if (tmp.next != null && i <= index - 1) {
            tmp.next = tmp.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
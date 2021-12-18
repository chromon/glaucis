/*
706. Design HashMap
Easy

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 

Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.
*/

/*
// 116 ms, faster than 13.55%
class MyHashMap {

    class Node{
        int val;
        int key;
        Node next;
        public Node(int key, int val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    Node first;
    
    public MyHashMap() {
        // Node first;
    }
    
    public void put(int key, int value) {
        Node n = new Node(key, value, first);
        first = n;
    }
    
    public int get(int key) {
        for(Node n = first; n != null; n = n.next){
            if(key == (n.key))
                return n.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        for(Node n = first; n != null; n = n.next){
            if(key == (n.key)){
                n.val = -1;
            }
        }
    }
}
*/

// 109 ms, faster than 14.48%
class MyHashMap {
    
    private int[] map;
    
    public MyHashMap() {
        map = new int[1000001];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
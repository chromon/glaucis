/*
460. LFU Cache
Hard

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[3,4], cnt(4)=2, cnt(3)=3
 

Constraints:

0 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
 
*/


class LFUCache {
    
    // key 到 val 的映射
    HashMap<Integer, Integer> kv;
    // key 到 freq 的映射
    HashMap<Integer, Integer> kf;
    // freq 到 key 列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> fk;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        kv = new HashMap<>();
        kf = new HashMap<>();
        fk = new HashMap<>();
        cap = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!kv.containsKey(key)) {
            return -1;
        }
        
        increaseFreq(key);
        return kv.get(key);
    }
    
    private void increaseFreq(int key) {
        int freq = kf.get(key);
        // 更新 kf
        kf.put(key, freq + 1);
        // 更新 fk
        // 将 key 从 freq 对应的列表中删除
        fk.get(freq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        fk.putIfAbsent(freq + 1, new LinkedHashSet<>());
        fk.get(freq + 1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (fk.get(freq).isEmpty()) {
            fk.remove(freq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
    
    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }
        
        // key 已存在，直接更新
        if (kv.containsKey(key)) {
            kv.put(key, value);
            increaseFreq(key);
            return;
        }
        
        // key 不存在，同时已超出容量，则删除最小频次 key
        if (cap <= kv.size()) {
            removeMinFreqKey();
        }
        
        // 插入 key value，同时频次 +1
        kv.put(key, value);
        kf.put(key, 1);
        // 插入 FK 表
        fk.putIfAbsent(1, new LinkedHashSet<>());
        fk.get(1).add(key);
        // 插入新 key 后最小的 freq 是 1
        this.minFreq = 1;
    }
    
    private void removeMinFreqKey() {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = fk.get(this.minFreq);
        // 其中最先被插入的 key 就是该被淘汰的 key
        int deletedKey = keyList.iterator().next();
        // 更新 fk
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            fk.remove(this.minFreq);
        }
        // 更新 kv
        kv.remove(deletedKey);
        // 更新 kf
        kf.remove(deletedKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
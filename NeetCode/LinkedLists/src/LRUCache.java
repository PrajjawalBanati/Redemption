import java.util.HashMap;

class DoubleNode {
    int key, val;
    DoubleNode prev, next;
    DoubleNode(int k, int v) {
        key = k;
        val = v;
    }
}
public class LRUCache {
    int capacity;
    HashMap<Integer, DoubleNode> map;
    DoubleNode head, tail;

    public LRUCache(int cap) {
        capacity = cap;
        map = new HashMap<>();
        head = new DoubleNode(-1, -1);
        tail = new DoubleNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DoubleNode node = map.get(key);
        removeNode(node);
        insertToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            node.val = value;
            removeNode(node);
            insertToTail(node);
        } else {
            if (map.size() == capacity) {
                DoubleNode lru = head.next;
                removeNode(lru);
                map.remove(lru.key);
            }
            DoubleNode newNode = new DoubleNode(key, value);
            insertToTail(newNode);
            map.put(key, newNode);
        }
    }

    void removeNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insertToTail(DoubleNode node) {
        DoubleNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
}

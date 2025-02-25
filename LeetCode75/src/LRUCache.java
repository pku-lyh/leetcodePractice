import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int size;
    int capacity;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
       DLinkedNode node = cache.get(key);
       if (node != null){
           // 移动到头部
           moveToHead(node);
           return node.value;
       }
       return -1;
    }

    private void moveToHead(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            // 新建节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity){
                DLinkedNode node1 = deleteNode(tail.prev);
                cache.remove(node1.key);
                size--;
            }
        }else {
            // 移动到头部
            node.value = value;
            moveToHead(node);
        }

    }

    private DLinkedNode deleteNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    private void addToHead(DLinkedNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
}

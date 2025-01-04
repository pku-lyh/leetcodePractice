import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, DlinkNode> map;
    DlinkNode head;
    DlinkNode tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        head = new DlinkNode();
        tail = new DlinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DlinkNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DlinkNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            map.put(key, new DlinkNode(key, value));
            size++;
            addToHead(map.get(key));
            if (size > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }
        }
    }


    private void moveToHead(DlinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DlinkNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DlinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static class DlinkNode {
        int key;
        int value;
        DlinkNode next;
        DlinkNode prev;

        public DlinkNode() {
        }

        public DlinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

import java.util.*;

class AllOne {

    // Bucket node for doubly linked list
    private static class Bucket {
        int count;
        Set<String> keys;
        Bucket prev, next;

        Bucket(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Bucket head, tail;
    private Map<String, Bucket> keyToBucket;

    public AllOne() {
        head = new Bucket(0);   // dummy head
        tail = new Bucket(0);   // dummy tail
        head.next = tail;
        tail.prev = head;
        keyToBucket = new HashMap<>();
    }

    public void inc(String key) {
        if (!keyToBucket.containsKey(key)) {
            // insert new key with count = 1
            Bucket first = head.next;
            if (first != tail && first.count == 1) {
                first.keys.add(key);
                keyToBucket.put(key, first);
            } else {
                Bucket newBucket = new Bucket(1);
                newBucket.keys.add(key);
                insertAfter(head, newBucket);
                keyToBucket.put(key, newBucket);
            }
        } else {
            Bucket curr = keyToBucket.get(key);
            Bucket next = curr.next;

            if (next != tail && next.count == curr.count + 1) {
                next.keys.add(key);
                keyToBucket.put(key, next);
            } else {
                Bucket newBucket = new Bucket(curr.count + 1);
                newBucket.keys.add(key);
                insertAfter(curr, newBucket);
                keyToBucket.put(key, newBucket);
            }

            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        }
    }

    public void dec(String key) {
        Bucket curr = keyToBucket.get(key);

        if (curr.count == 1) {
            // remove key completely
            curr.keys.remove(key);
            keyToBucket.remove(key);
            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        } else {
            Bucket prev = curr.prev;

            if (prev != head && prev.count == curr.count - 1) {
                prev.keys.add(key);
                keyToBucket.put(key, prev);
            } else {
                Bucket newBucket = new Bucket(curr.count - 1);
                newBucket.keys.add(key);
                insertAfter(curr.prev, newBucket);
                keyToBucket.put(key, newBucket);
            }

            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                remove(curr);
            }
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }

    // Doubly linked list helpers
    private void insertAfter(Bucket prev, Bucket node) {
        node.prev = prev;
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
    }

    private void remove(Bucket node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
package myhashmap;

public class MyHashMap<K, V> {
    private Node<K, V> buckets[];
    int size = 0;

    public MyHashMap() {
        this.buckets = new Node[8];
    }

    public void put(Object key, Object value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Node<K, V> node = new Node<>();
        node.setKey((K) key);
        node.setValue((V) value);
        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = node;
        } else if (contains((K) key)) {
            size--;
        } else {
            node.setNext(buckets[bucketNumber]);
            buckets[bucketNumber] = node;
        }
        size++;
    }

    public V remove(Object key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        size--;
        Node<K, V> currentNode = buckets[bucketNumber];
        Node<K, V> prevNode = buckets[bucketNumber];
        if (!contains((K) key)) {
            size++;
            return null;
        } else if (currentNode.getNext() == null && currentNode.getKey().equals((K) key)) {
            V value = currentNode.getValue();
            currentNode.setNext(null);
            currentNode.setKey(null);
            currentNode.setValue(null);
            return value;
        }
        while (currentNode.getNext() != null) {
            V value = currentNode.getValue();
            if (currentNode.getKey().equals((K) key)) {
                while (!prevNode.getNext().equals(currentNode)) {
                    prevNode = prevNode.getNext();
                }
                prevNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                currentNode.setKey(null);
                currentNode.setValue(null);
            }
            currentNode = currentNode.getNext();

            return value;
        }
        return isEqual(currentNode, (K) key);
    }

    public void clear() {
        this.buckets = new Node[8];
        size = 0;
    }

    public V get(Object key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Node<K, V> currentNode = buckets[bucketNumber];
        if (currentNode.getKey() == null) {
            return null;
        }
        while (currentNode.getNext() != null) {
            V value = isEqual(currentNode, (K) key);
            if (value != null) {
                return value;
            }
            currentNode = currentNode.getNext();
        }
        return isEqual(currentNode, (K) key);
    }

    public int size() {
        return size;
    }

    private V isEqual(Node<K, V> node, K key) {
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
        return null;
    }

    private boolean contains(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        return get(key) != null;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> song = new MyHashMap<String, String>();
        song.put("Old", "McDonald");
        song.put("had", "a farm");
        song.put("Ee i", "ee i o");
        song.put("And", "on his farm");
        song.put("he", "had some cows");
        System.out.println("song.get(\"Old\") = " + song.get("Old"));
        System.out.println("song.get(\"Ee i\") = " + song.get("Ee i"));
        song.put("Ee i", "ee i o");
        System.out.println("song.size() = " + song.size());
        System.out.println("song.contains(\"Ee i\") = " + song.contains("Ee i"));
        System.out.println("song.size() = " + song.size());
        System.out.println("song.remove(\"Ee i\") = " + song.remove("Ee i"));
        System.out.println("song.get(\"Ee i\") = " + song.get("Ee i"));
        System.out.println("song.size() = " + song.size());

    }
}

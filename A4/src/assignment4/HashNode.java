package assignment4;

public  class HashNode<K,V> implements Cloneable {
    // Fields
    private K key;
    private V value;
    public HashNode<K,V> next;

    // Constructor
    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    // ADD HELPER METHODS BELOW HERE

    // Setter for node's value
    public void setValue(V value) {
        this.value = value;
    }

    // ADD HELPER METHODS ABOVE HERE

    // Returns this hash nodes's key
    // Assume entry is not null
    public K getKey() {
        return this.key;
    }

    // Returns this hash entry's value
    // Assume entry is not null
    public V getValue() {
        return this.value;
    }

    // Return Next node
    HashNode<K,V> getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return key.toString() + " : " + value.toString();
    }

}

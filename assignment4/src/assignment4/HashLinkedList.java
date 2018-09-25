package assignment4;

public class HashLinkedList<K,V> {
    // Fields
    private Integer size;
    private HashNode<K,V> head;

    // Constructor
    HashLinkedList() {
        head = null;
        size = 0;
    }


    // Add (Hash)node at the front of the linked list
    public void add(K key, V value) {
        // ADD CODE BELOW HERE

        HashNode<K,V> oldHead = head;

        head = new HashNode<K,V>(key, value);
        head.next = oldHead;
        size++;

        // ADD CODE ABOVE HERE
    }


    // Get Hash(node) by key
    // Returns the node with key
    public HashNode<K,V> getListNode(K key) {
        // ADD CODE BELOW HERE

        if (isEmpty())
            return null;

        HashNode<K,V> nextNode = head;

        while (nextNode != null) {
            if (key.equals(nextNode.getKey()))
                return nextNode;
            else
                nextNode = nextNode.getNext();
        }

        return null;

        // ADD CODE ABOVE HERE
    }


    // Remove the head node of the list
    // Note: Used by remove method and next method of hash table Iterator
    public HashNode<K,V> removeFirst() {
        // ADD CODE BELOW HERE

        if (isEmpty())
            return null;

        HashNode<K,V> oldHead = head;
        head = head.getNext();
        size--;

        return oldHead;

        // ADD CODE ABOVE HERE
    }


    // Remove Node by key from linked list
    public HashNode<K,V> remove(K key) {
        // ADD CODE BELOW HERE

        if (isEmpty())
            return null;

        if (key.equals(head.getKey()))
            return removeFirst();

        HashNode<K,V> prevNode = head;
        HashNode<K,V> curNode = prevNode.getNext();

        while (curNode != null) {
            if (key.equals(curNode.getKey())) {
                size--;
                prevNode.next = curNode.getNext();
                return curNode;
            } else {
                prevNode = curNode;
                curNode = curNode.getNext();
            }
        }

        return null;

        // ADD CODE ABOVE HERE
    }


    // Delete the whole linked list
    public void clear() {
        head = null;
        size = 0;
    }


    // Check if the list is empty
    boolean isEmpty() {
        return size == 0 ? true : false;
    }


    int size() {
        return this.size;
    }

    //ADD YOUR HELPER  METHODS BELOW THIS

    HashNode<K,V> getHead() {
        return head;
    }

    //ADD YOUR HELPER METHODS ABOVE THIS
}

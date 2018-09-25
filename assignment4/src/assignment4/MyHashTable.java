package assignment4;

import java.util.Iterator;
import java.util.ArrayList;

class MyHashTable<K,V> {
    // Number of entries in the HashTable
    private int entryCount = 0;

    // Number of buckets. The constructor sets this variable to its initial value,
    // which eventually can get changed by invoking the rehash() method
    private int numBuckets;

    // Threshold load factor for rehashing
    private final double MAX_LOAD_FACTOR=0.75;

    // Buckets to store lists of key-value pairs
    // Traditionally an array is used for the buckets and a linked list is used for the entries within each bucket
    ArrayList<HashLinkedList<K,V>> buckets;

    // Constructor
    // numBuckets is the initial number of buckets used by this hash table
    MyHashTable(int numBuckets) {
        // ADD YOUR CODE BELOW HERE

        this.numBuckets = numBuckets;
        this.buckets = new ArrayList<HashLinkedList<K,V>>(numBuckets);

        for (int i = 0; i < numBuckets; i++)
            this.buckets.add(new HashLinkedList<K,V>());

        // ADD YOUR CODE ABOVE HERE
    }


    // Adds a key-value pair to the hash table. If the load factor goes above the
    // MAX_LOAD_FACTOR, then call the rehash() method after inserting.

    // If there was a previous value for the given key in this hash table,
    // then overwrite it with new value and return the old value.
    // Otherwise return null.
    public V put(K key, V value) {
        // ADD YOUR CODE BELOW HERE

        int hashValue = hashFunction(key);

        // Create HashLL if doesn't exist
        if (buckets.get(hashValue) == null)
            buckets.set(hashValue, new HashLinkedList<K,V>());

        // Existing node with key
        if (containsKey(key)) {
            V oldValue = buckets.get(hashValue).getListNode(key).getValue();
            buckets.get(hashValue).getListNode(key).setValue(value);
            return oldValue;
        }

        entryCount++;
        buckets.get(hashValue).add(key, value);

        if ((double)entryCount / (double)numBuckets > MAX_LOAD_FACTOR)
            rehash();

        return null;

        // ADD YOUR CODE ABOVE HERE
    }


    // Retrieves a value associated with some given key in the hash table
    // Returns null if the key could not be found in the hash table
    public V get(K key) {
        // ADD YOUR CODE BELOW HERE

        if (!containsKey(key))
            return null;

        return buckets.get(hashFunction(key)).getListNode(key).getValue();

        // ADD YOUR CODE ABOVE HERE
    }


    // Removes a key-value pair from the hash table
    // Return value associated with the provided key. If the key is not found, return null
    public V remove(K key) {
        // ADD YOUR CODE BELOW HERE

        if (!containsKey(key))
            return null;

        entryCount--;
        return buckets.get(hashFunction(key)).remove(key).getValue();

        // ADD YOUR CODE ABOVE HERE
    }


    // Create a new hash table that has twice the number of buckets
    public void rehash() {
        // ADD YOUR CODE BELOW HERE

        ArrayList<HashLinkedList<K,V>> newBuckets = new ArrayList<HashLinkedList<K,V>>(2 * numBuckets);

        for (int i = 0; i < 2 * numBuckets; i++)
            newBuckets.add(new HashLinkedList<K,V>());

        HashIterator allNodes = iterator();

        buckets = newBuckets;
        entryCount = 0;
        numBuckets = 2 * numBuckets;

        while (allNodes.hasNext()) {
            HashNode<K,V> node = allNodes.next();
            put(node.getKey(), node.getValue());
        }

        // ADD YOUR CODE ABOVE HERE
    }


    // Returns an iterator for the hash table
    public MyHashTable<K,V>.HashIterator iterator() {
        return new HashIterator();
    }


    // Removes all the entries from the hash table but keeps the number of buckets intact
    public void clear() {
        for (int ct = 0; ct < buckets.size(); ct++)
            buckets.get(ct).clear();
        entryCount = 0;
    }


    // Checks if the hash table contains the given key
    // Return true if the hash table has the specified key, and false otherwise
    public boolean containsKey(K key) {
        if (buckets.get(hashFunction(key)).getListNode(key) == null)
            return false;
        return true;
    }


    // Return an ArrayList of the keys in the hash table
    public ArrayList<K> keys() {
        // ADD YOUR CODE BELOW HERE

        HashIterator keyIterable = iterator();
        ArrayList<K> listKeys = new ArrayList<K>();

        while (keyIterable.hasNext())
            listKeys.add(keyIterable.next().getKey());

        return listKeys;

        // ADD YOUR CODE ABOVE HERE
    }


    // Return an ArrayList of the values in the hash table
    public ArrayList<V> values() {
        // ADD YOUR CODE BELOW HERE

        HashIterator valueIterable = iterator();
        ArrayList<V> listValues = new ArrayList<V>();

        while (valueIterable.hasNext())
            listValues.add(valueIterable.next().getValue());

        return listValues;

        // ADD YOUR CODE ABOVE HERE
    }


    // Given a key, return the bucket position for the key
    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % numBuckets;
    }


    // Return the number of entries in the hash table
    public int size() {
        return entryCount;
    }


    // This method is used for testing rehash()
    public int getNumBuckets() {
        return numBuckets;
    }


    // Checking if the hash table is empty
    public boolean isEmpty() {
        if (entryCount == 0)
            return true;
        else
            return false;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buckets.size(); i++) {
            sb.append("Bucket ");
            sb.append(i);
            sb.append(" has ");
            sb.append(buckets.get(i).size());
            sb.append(" entries.\n");
        }
        sb.append("There are ");
        sb.append(entryCount);
        sb.append(" entries in the hash table altogether.");
        return sb.toString();
    }


    // Inner class: Iterator for the Hash Table
    public class HashIterator implements Iterator<HashNode<K,V>> {
        HashLinkedList<K,V> allEntries;

        // Constructor: Make a HashLinkedList 'allEntries' of all the entries in the hash table
        public HashIterator() {
            // ADD YOUR CODE BELOW HERE

            allEntries = new HashLinkedList<K,V>();

            for (int table_idx = 0; table_idx < numBuckets; table_idx++) {
                HashNode<K,V> nextNode = buckets.get(table_idx).getHead();

                while (nextNode != null) {
                    allEntries.add(nextNode.getKey(), nextNode.getValue());
                    nextNode = nextNode.getNext();
                }
            }

            // ADD YOUR CODE ABOVE HERE
        }

        @Override
        public boolean hasNext() {
            return !allEntries.isEmpty();
        }

        @Override
        public HashNode<K,V> next() {
            return allEntries.removeFirst();
        }

        @Override
        public void remove() {
            // Not implemented, but must be declared because it is in the Iterator interface
        }
    }
}

package uebung03.HashTable;

public class HashTableTemplate {

    
    private int numberOfCollisions = 0;  // statistics counter for collisions
    
    public int getStat () {
    	return numberOfCollisions;
    }

    public HashTableTemplate () { // hash table with default size = 10, default probing = linear
    }

    public void clear() { // clear hash table
    }

    public boolean isEmpty() {
       return true;
    }

    public void printHT() {
    }

    public int size() {
       return 0;
    }

    public void reHash() { // only for reason of test to enforce rehashing
    }   

    public Object put(Object key, Object value) {
       return null;
    }

    public boolean remove(Object key) {
    	return true;
    }

    public Object get(Object key) {
       return null;
    }

    public boolean containsKey(Object key) {
       return true;
    }

    public boolean contains(Object value) {
       return true;
    }
}

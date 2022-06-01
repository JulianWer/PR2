package uebung03.HashTable;

import uebung03.HashTable.ProbingAlgorithms.LinearProbing;
import uebung03.HashTable.ProbingAlgorithms.QuadraticProbing;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static java.lang.Math.abs;

public class HashTable {
    private ElementOfHashTable[] elementsOfHashTables; // init Elements Array
    private final int DEFAULT_SIZE = 10; // init default size of Array to 10
    private Probing probing; // init probing
    public int numberOfCollisions = 0;  // statistics counter for collisions

    public int getStat() {
        return this.countCollisions();
    }  // gets the collisions

    public HashTable() { // hash table with default size , default probing = linear
        this.elementsOfHashTables = new ElementOfHashTable[this.DEFAULT_SIZE];
        this.probing = new LinearProbing();

    }

    public HashTable(int size) { // hash table with init size , default probing = linear
        this.elementsOfHashTables = new ElementOfHashTable[size];
        this.probing = new LinearProbing();
    }

    public HashTable(int size, Probing probing) { // hash table with init size, init probing
        this.elementsOfHashTables = new ElementOfHashTable[size];
        this.probing = probing;
    }

    public int sizeOfHashTable() {
        return this.elementsOfHashTables.length;
    } // get the size of the Hashtable

    public void clear() { // clear hash table
        for (ElementOfHashTable v : this.elementsOfHashTables)
            v = null;
    }

    public boolean isEmpty() { // checks if the table is empty
        for (ElementOfHashTable v : this.elementsOfHashTables)
            if (v == null)
                return true; // returns true if all elements are null
        return false;
    }

    public void printHT() { // prints out the HashTable
        for (int i = 0; i < this.elementsOfHashTables.length; i++) {
            if (this.elementsOfHashTables[i] == null) // hop over the empty fields
                continue;
            println(i + "=> " + ((SongImplementation) this.elementsOfHashTables[i].value).toString() + "      //  " + this.elementsOfHashTables[i].overwrite);
        }
    }

    public int size() { // return the size of all written elements
        int count = 0;
        for (ElementOfHashTable v : this.elementsOfHashTables)
            if (v != null && !v.overwrite) // if the element is not empty and has no overwrite flag from the remove method
                count++;
        return count; // return the count
    }

    public int sizeWithDeletedElements() { // return the size of all written elements
        int count = 0;
        for (ElementOfHashTable v : this.elementsOfHashTables)
            if (v != null) // if the element is not empty and has no overwrite flag from the remove method
                count++;
        return count; // return the count
    }

    public void reHash() { // only for reason of test to enforce rehashing
        ElementOfHashTable[] vals = this.elementsOfHashTables.clone(); // clones the old array to vals
        this.elementsOfHashTables = new ElementOfHashTable[this.elementsOfHashTables.length * 2]; // new Array with two times the size of the old
        for (ElementOfHashTable v : vals) {
            if (v != null && !v.overwrite) {
                this.put(v.key, v.value); // puts all elements in with no overwrite flag
            }
        }
    }

    private void checkForRehash(){
        double dbl = ((double) this.size() / (double) this.sizeOfHashTable()); // get the percentage of the array
        if (dbl >= 0.75) // 75% filled
            this.reHash(); // rehashes the table
        if (this.probing instanceof QuadraticProbing) // if probing is an instance of the squared probing
            if (dbl >= 0.75) // 50% filled
                this.reHash();
    }

    public Object put(Object key, Object value) {
        //rehash


        int index = hashFunction(key); // declair index with the hashfunction of the key
        this.probing.startProbing(); // start probing
        Object returnValue = null;
        int count = 0;
        for (; ; ) { // endless for loop
            if (this.elementsOfHashTables[index] == null || this.elementsOfHashTables[index].overwrite) { // when the element is null or the overwrite flag is true
                this.elementsOfHashTables[index] = new ElementOfHashTable(value, key); //  set to this element a new Element with the value and key
                this.elementsOfHashTables[index].overwrite = false; // set the overwrite flag to false
                checkForRehash();
                returnValue = null;
                break;
            }
            if (this.elementsOfHashTables[index].key.equals(key)) { // if there is an element, return the old element and overwrite it
                Object val = this.elementsOfHashTables[index].value;
                this.elementsOfHashTables[index] = new ElementOfHashTable(value, key);
                returnValue = val;
                checkForRehash();
                break;
            }
            if(count > this.elementsOfHashTables.length - this.size())
                reHash();
            count++;
            index = this.modulo(index + this.probing.nextNum(this), this.elementsOfHashTables.length);    //calculate the next index

        }
        return returnValue;
    }

    public int newcountCollisions(){
        int collisions = 0;
        for(ElementOfHashTable e : this.elementsOfHashTables){
            if (e != null) {
                int hashcode = this.hashFunction(e.key);
                for(ElementOfHashTable v : this.elementsOfHashTables){
                    if(!e.equals(v) && hashcode == this.hashFunction(v.key)){
                        collisions++;
                    }
                }
            }

        }
        return collisions;
    }
    public int countCollisions(){
        //return countCollisions();
        int collisions = 0;
        int count = 0;
        for(ElementOfHashTable e : this.getElementSet()){
            int expectedIndex = this.hashFunction(e.key);
            boolean found = false;
            while(!found){
                if(this.elementsOfHashTables[expectedIndex] == null){
                    found = true;
                }else {
                    if (!this.elementsOfHashTables[expectedIndex].equals(e)) {
                        if(count > this.elementsOfHashTables.length - this.size() + 800 - 105)
                            found = true;
                        count++;
                        collisions++;
                        expectedIndex = this.modulo(expectedIndex + this.probing.nextNum(this), this.elementsOfHashTables.length);
                    } else {
                        found = true;
                    }
                }

            }

        }

        return collisions;
    }


    private ElementOfHashTable[] getElementSet(){
        ElementOfHashTable elements[] = new ElementOfHashTable[this.sizeWithDeletedElements()];
        int count = 0;
        for(int i = 0; i < this.elementsOfHashTables.length; i++){
            if(this.elementsOfHashTables[i] != null){
                elements[count++] = this.elementsOfHashTables[i];
            }
        }
        return elements;
    }
    public boolean remove(Object key) {
        if (!this.containsKey(key)) // if the key is not in the table return false
            return false;

        this.probing.startProbing(); // start probing
        int index = modulo(key.hashCode(), this.elementsOfHashTables.length); // calculate the index of the element
        boolean removeFlag = false; // flag for the do while loop

        do {
            if (this.elementsOfHashTables[index].key.equals(key)) { // checks if equals and checks the overwrite flag
                if (this.elementsOfHashTables[index].overwrite) {
                    return false; // if overwrite ture, return false
                }
                this.elementsOfHashTables[index].overwrite = true; // set the overwrite flag true
                removeFlag = true; // and set the removeFlag true to break the loop
            } else {
                index = this.modulo(index + this.probing.nextNum(this), this.elementsOfHashTables.length); // get new index
            }
        } while (!removeFlag);

        return true; // if the element is removed( overwrite = true) return true;
    }

    public Object get(Object key) {
        //return this.elementsOfHashTables[this.hashFunction(key)].getValue(); // gets the element of the key
        int index = this.hashFunction(key);
        this.probing.startProbing();
        for(;;){
            if(elementsOfHashTables[index].key.equals(key))
                return elementsOfHashTables[index].getValue();
            else
                index = this.modulo(index + this.probing.nextNum(this), this.elementsOfHashTables.length);
        }
    }

    public boolean containsKey(Object key) {
        //return this.elementsOfHashTables[hashFunction(key)] != null;
        int index = this.hashFunction(key);
        this.probing.startProbing();
        int limit = this.elementsOfHashTables.length;
        for(int i = 0; i < limit; i++){
            if(elementsOfHashTables[index].key.equals(key))
                return true;
            else
                index = this.modulo(index + this.probing.nextNum(this), this.elementsOfHashTables.length);

        }
        return false;
    } // check if the table contains the key and the key is not null

    public boolean contains(Object value) { // check if the table contains the value
        for (ElementOfHashTable v : this.elementsOfHashTables) {
            if (v != null && v.value != null) {
                if (v.value.equals(value))
                    return true;
            }
        }

        return false;
    }

    //use Hashfunction from String
    private int hashFunction(Object key) {
        int value = 0;
        if (key instanceof String) {
            int n = key.hashCode();
            int m = this.elementsOfHashTables.length;

            return (this.modulo(n, m));  //calculates the array index
        }
        return 0;
    }

    private int modulo(int n, int m) {
        return (n < 0) ? (m - (abs(n) % m)) % m : (n % m); // own modulo operator for the absolut modulo
    }

}

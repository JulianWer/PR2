package uebung03.HashTable;

import uebung03.HashTable.ProbingAlgorithms.LinearProbing;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static java.lang.Math.abs;

public class HashTable {
    //songtitel = key, value = songobject
    private Value[] values;
    private final int DEFAULT_SIZE = 10;
    private Probing probing;
    private int numberOfCollisions = 0;  // statistics counter for collisions
    private int sizeOfHashTable;


    public int getStat() {
        return numberOfCollisions;
    }

    public HashTable() { // hash table with default size = 10, default probing = linear
        //default size = 10
        this.values = new Value[this.DEFAULT_SIZE];
        this.sizeOfHashTable = this.DEFAULT_SIZE;
        this.probing = new LinearProbing();

    }

    public HashTable(int size) {
        this.values = new Value[size];
        this.sizeOfHashTable = size;
        this.probing = new LinearProbing();
    }

    public HashTable(int size, Probing probing) {
        this.values = new Value[size];
        this.sizeOfHashTable = size;
        this.probing = probing;
    }

    public int sizeOfHashTable() {
        return this.values.length;
    }

    public void clear() { // clear hash table
        for (Value v : this.values)
            v = null;
    }

    public boolean isEmpty() {
        for (Value v : this.values)
            if (v != null)
                return true;
        return false;
    }

    public void printHT() { // prints out the HashTable
        for (int i = 0; i < this.values.length; i++) {
            if (this.values[i] == null)
                continue;
            println(i + "=> " + ((SongImplementation) this.values[i].value).toString() + "      //  " + this.values[i].overwrite);
        }
    }

    public int size() {
        int count = 0;
        for (Value v : this.values)
            if (v != null && !v.overwrite)
                count++;
        return count;
    }

    public void reHash() { // only for reason of test to enforce rehashing
        Value[] vals = this.values.clone();
        this.values = new Value[this.values.length * 2];
        for (Value v : vals) {
            if (v != null && !v.overwrite) {
                this.put(v.key, v.value);
            }
        }
    }

    public Object put(Object key, Object value) {
        //rehash
        double dbl = ((double) this.size() / (double) this.sizeOfHashTable());
        if (dbl >= 0.75)
            this.reHash();
        int index = hashFunction(key);
        this.probing.startProbing();
        for (; ; ) {
            //index = hashFunction(key);
            if (this.values[index] == null || this.values[index].overwrite) {
                this.values[index] = new Value(value, key);
                this.values[index].overwrite = false;
                return null;
            }
            if (this.values[index].key.equals(key)) {
                Object val = this.values[index].value;
                this.values[index] = new Value(value, key);
                return val;
            }

            index = this.modulo(index + this.probing.nextNum(), this.values.length);    //calculate the next index
            //println(size());
        }
    }

    public boolean remove(Object key) {
        if (!this.containsKey(key))
            return false;


        this.probing.startProbing();
        int index = modulo(key.hashCode(), this.values.length);
        boolean removeFlag = false;

        do {
            if (this.values[index].key.equals(key)) {
                if (this.values[index].overwrite) {
                    return false;
                }
                this.values[index].overwrite = true;
                removeFlag = true;
            } else {
                index = this.modulo(index + this.probing.nextNum(), this.values.length);
            }

        } while (!removeFlag);

        return true;
    }

    public Object get(Object key) {
        return this.values[this.hashFunction(key)].getValue();
    }

    public Object get2(Object key) {
        int index = modulo(key.hashCode(), this.values.length);
        for (; ; ) {
            if (this.values[index].key.equals(key)) {
                return this.values[index];
            } else {
                index = this.modulo(index + this.probing.nextNum(), this.values.length);
            }

        }
    }

    public boolean containsKey(Object key) {
//        for (int i = 0; i < this.values.length; i++) {
//            if(this.)
//        }
        return this.values[hashFunction(key)] != null;
    }

    public boolean contains(Object value) {
        for (Value v : this.values) {
            if (v != null && v.value != null) {
                if (v.value.equals(value))
                    return true;
            }
        }

        return false;
    }

    //Hashfunktion aus String verwenden
    private int hashFunction(Object key) {
        int value = 0;
        if (key instanceof String) {
            // for(int i = 0; i < ((String) key).length(); i++){   //calculates the value of a string by adding all chars together
            //   value += ((String)key).charAt(i);
            //}
            int n = key.hashCode();
            int m = this.values.length;

            return (this.modulo(n, m));  //calculates the array index
        }
        return 0;
    }

    private int modulo(int n, int m) {
        return (n < 0) ? (m - (abs(n) % m)) % m : (n % m);
    }


}

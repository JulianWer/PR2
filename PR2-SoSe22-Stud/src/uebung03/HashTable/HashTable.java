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

    public int getStat () {
        return numberOfCollisions;
    }

    public HashTable () { // hash table with default size = 10, default probing = linear
        //default size = 10
        this.values = new Value[this.DEFAULT_SIZE];
        this.probing = new LinearProbing();

    }

    public HashTable(int size){
        this.values = new Value[size];
        this.probing = new LinearProbing();
    }

    public HashTable(int size, Probing probing){
        this.values = new Value[size];
        this.probing = probing;
    }

    public void clear() { // clear hash table
        for(Value v : this.values)
            v = null;
    }

    public boolean isEmpty() {
        for(Value v : this.values)
            if(v != null)
                return true;
        return false;
    }

    public void printHT() {
    }

    public int size() {
        int count = 0;
        for(Value v : this.values)
            if(v != null)
                count++;
        return count;
    }

    public void reHash() { // only for reason of test to enforce rehashing
    }

    public Object put(Object key, Object value) {
        println();
        println("put function: ");
        //key = songname
        boolean valueIsInserted = false;
        int index = this.hashFunction(key);
        this.probing.startProbing();
        do {
            println("Hashindex" + index);
            if (this.values[index] == null) { //value can be inserted => no collision
                this.values[index] = new Value(value);
                valueIsInserted = true;
            } else {
                //collision happened
                this.numberOfCollisions++;
                index = this.modulo(index + this.probing.nextNum(), this.values.length);    //calculate the next index
            }
        }while(!valueIsInserted);

        return null;
    }

    public boolean remove(Object key) {
        if(!this.contains(key))
            return false;
        int index = modulo(key.hashCode(), this.values.length);

       return true;
    }

    public Object get(Object key) {
        return this.values[this.hashFunction(key)];
    }

    public boolean containsKey(Object key) {
        return this.values[hashFunction(key)] != null;
    }

    public boolean contains(Object value) {
        for(Object o : this.values)
            if(o.equals(value))
                return true;
        return false;
    }

    //Hashfunktion aus String verwenden
    private int hashFunction(Object key){
        int value = 0;
        if(key instanceof String){
           // for(int i = 0; i < ((String) key).length(); i++){   //calculates the value of a string by adding all chars together
             //   value += ((String)key).charAt(i);
            //}
            int n = key.hashCode();
            int m = this.values.length;

            return (this.modulo(n, m));  //calculates the array index
        }
        return 0;
    }

    private int modulo(int n, int m){
        return (n < 0) ? (m - (abs(n) % m) ) %m : (n % m);
    }
}

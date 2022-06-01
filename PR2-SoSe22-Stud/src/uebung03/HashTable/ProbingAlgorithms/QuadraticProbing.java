package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.HashTable;
import uebung03.HashTable.Probing;

public class QuadraticProbing implements Probing {
    private int counter = 0;
    private final int distance = 1; // default
    private boolean sign = true;

    @Override
    public int nextNum(HashTable t){
        t.numberOfCollisions++;
        return this.nextNum();
    }

    // is always alternating
    @Override
    public int nextNum() { // gets next number
        counter = (int) (distance + Math.pow(counter, 2)); // inits distance and counter squared to  counter
        if (sign) { // switch always between counter and counter *(-1)
            sign = false;
            return counter;
        } else {
            sign = true;
            return ((-1) * counter);
        }
    }

    @Override
    public void startProbing() {// start probing
        sign = true;
        counter = 0; // counter to 0
    }
}

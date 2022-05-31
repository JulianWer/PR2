package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.Probing;

public class QuadraticProbing implements Probing {
    private int counter = 0;
    private final int distance = 1;
    private boolean sign = true;


    @Override
    public int nextNum() {
        counter = (int) (distance + Math.pow(counter, 2));
        if (sign) {
            sign = false;
            return counter;
        } else {
            sign = true;
            return ((-1) * counter);
        }
    }

    @Override
    public void startProbing() {
        sign = true;
        counter = 0;
    }
}

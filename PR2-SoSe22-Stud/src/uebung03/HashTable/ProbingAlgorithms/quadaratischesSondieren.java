package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.Probing;

public class quadaratischesSondieren implements Probing {
    private int counter = 0;
    private int distance = 1;
    private boolean sign = true;

    public quadaratischesSondieren(int distance) {
        this.distance = distance;
    }

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

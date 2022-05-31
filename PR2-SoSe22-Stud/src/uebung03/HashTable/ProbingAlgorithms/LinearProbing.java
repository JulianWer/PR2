package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.Probing;

public class LinearProbing implements Probing {
    private int counter;
    private int distance = 1;   //default = 1
    private int alternierend;
    boolean sign = true;    //true positive

    public LinearProbing() {
        this(1, -1);
    }

    public LinearProbing(int distance, int alternierend) {
        this.alternierend = alternierend;
        this.distance = distance;
    }

    @Override
    public int nextNum() {  //returns an offset
        counter = counter + this.distance;
        if (alternierend < 0) {
            if (sign) {
                sign = !sign;
                return counter;
            } else {
                sign = !sign;
                return ((-1) * counter);
            }
        } else {
            return counter;
        }
    }

    @Override
    public void startProbing() {
        sign = true;
        counter = 0;
    }


}

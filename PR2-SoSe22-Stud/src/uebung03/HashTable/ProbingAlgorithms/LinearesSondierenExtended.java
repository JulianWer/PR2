package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.Probing;

public class LinearesSondierenExtended implements Probing {
    private int counter;
    private int distance = 1;   //default = 1
    private boolean alternierend;
    boolean sign = true;    //true positive
    @Override
    public int nextNum() {  //returns an offset
        counter = counter + distance;
        if(alternierend) {
            if (sign) {
                sign = !sign;
                return counter;
            } else {
                sign = !sign;
                return ((-1) * counter);
            }
        }else{
            return counter;
        }
    }

    @Override
    public void startProbing() {
        sign = true;
        counter = 0;
    }

    public LinearesSondierenExtended(int distance, boolean alternierend){
        this.alternierend = alternierend;
        this.distance = distance;
    }
}

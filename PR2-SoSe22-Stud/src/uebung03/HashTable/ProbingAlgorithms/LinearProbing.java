package uebung03.HashTable.ProbingAlgorithms;

import uebung03.HashTable.Probing;

public class LinearProbing implements Probing {
//returns offset
    private int counter;
    boolean sign = true;    //true positive
    @Override
    public int nextNum() {  //returns an offset
        counter++;
        if(sign){
            sign = !sign;
            return counter;
        }else{
            sign = !sign;
            return ((-1) * counter);
        }
    }

    @Override
    public void startProbing() {
        sign = true;
        counter = 0;
    }
}

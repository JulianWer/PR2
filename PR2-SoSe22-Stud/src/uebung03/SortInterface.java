package uebung03;

import uebung02.QickSort.StatObject;

public interface SortInterface {

    public void sort(Comparable[] F , int u, int o);
    public void sort(Comparable[] F , StatObject so);
    public int split(Comparable[] F , int u, int o);
    public void swap(Comparable[] F ,int i1 , int i2);

    static void sortArray(Comparable[] array, uebung03.SortInterface s){
        s.sort(array, new StatObject());
    }
}

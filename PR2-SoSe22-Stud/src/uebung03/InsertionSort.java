package uebung03;

import uebung02.QickSort.StatObject;

import static gdi.MakeItSimple.print;
import static pr.MakeItSimple.println;

public class InsertionSort implements SortInterface {


    @Override
    public void sort(Comparable[] F, StatObject so) {
        this.sort(F, 0, F.length - 1, 1);
    }

    @Override
    public void sort(Comparable[] A, StatObject so, int direction) {
        this.sort(A, 0, A.length - 1, direction);
    }

    public void sort(Comparable[] array, int u, int o, int direction) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            Comparable m = array[i];
            while (j > 0 && (array[j - 1].compareTo(m) * direction) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = m;
        }
    }
}

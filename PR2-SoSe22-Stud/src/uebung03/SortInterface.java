package uebung03;

import uebung02.QickSort.StatObject;

public interface SortInterface {

    public void sort(Comparable A[], StatObject so);   // Sortierverfahren mit 2. Objekt zum Sammeln von Statistikdaten

    public void sort(Comparable A[], StatObject so, int direction);

    static void sortArray(Comparable[] array, uebung03.SortInterface s) {
        s.sort(array, new StatObject());
    }
}

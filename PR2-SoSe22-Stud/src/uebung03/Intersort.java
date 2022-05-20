package uebung03;

public class Intersort {
    public void insertionSort (Comparable [] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i;
            Comparable m = array[i];
            while (j > 0 && array[j - 1].compareTo(m) > 0 ) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = m;
        }
    }
}

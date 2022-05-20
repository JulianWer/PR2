package uebung03;

public class Intersort {
    static void insertionSort (int [] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int m = array[i];
            while (j > 0 && array[j - 1] > m) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = m;
        }
    }
}

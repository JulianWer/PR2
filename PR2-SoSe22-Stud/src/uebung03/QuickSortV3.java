package uebung03;


import uebung03.Elements.IntElement;
import uebung02.QickSort.StatObject;

import static gdi.MakeItSimple.*;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class QuickSortV3 implements SortInterface {
    StatObject so;


    public static void main(String args[]){

        println("QuickSortV3");
        IntElement array[] = {new IntElement(10), new IntElement(7), new IntElement(1), new IntElement(97), new IntElement(14), new IntElement(2), new IntElement(1),new IntElement(100) };
        SortInterface.sortArray(array, new QuickSortV3());
        print("\n");
        for(Comparable t : array)
            print(" " + ((IntElement) t).getKey());
    }
    @Override
    public void sort(Comparable[] F, StatObject so) { // overload method sort for testing
        // TODO Auto-generated method stub
        this.so = so;
        sort(F, 0, F.length - 1); // call the normal sort method this sort(int[] F, int u, int o)

    }

    @Override
    public void sort(Comparable[] F, int u, int o) {
        if(F.length <= 1 ) so.incrunCounter();
        if (o > u) { // runs as long as the upper cabinets is greater than the under
            // count runs for statistics
            so.incrunCounter();
            int i = split(F, u, o);// call split method and write the index to i
            sort(F, u, i - 1); // set upper cabinets one down
            sort(F, i + 1, o); // set under cabinets one up
        }

    }

    // The split method is the main operation for the program, the parameters are
    // the Array and upper,under cabinets
    @Override
    public int split(Comparable[] F, int u, int o) {
        // TODO Auto-generated method stub

        int p = o; // set the pivot element to the upper cabinets
        int index = u; // set index to under cabinets
        for (int zeiger = u; zeiger <= o - 1; zeiger++) {
            so.inccomparisonCounter(); // set comparisonCounter one up
            //if (F[zeiger] <= F[p]) { // compare both elements
            if (F[zeiger].compareTo(F[p]) >= 0 ) {

                if (zeiger != index) // swap only if the variables are not the same
                    swap(F, index, zeiger); // the root array gets changed
                index++; // increment index

            }
        }
        if (index != o) // swap only if index is not the same as the upper cabinets
            swap(F, index, p);


        return index;
    }

    @Override
    public void swap(Comparable[] F, int i1, int i2) { // swap method
        // TODO Auto-generated method stub
        so.incswapCounter(); // count swap counter one up
        Comparable remember = F[i1];
        F[i1] = F[i2];
        F[i2] = remember;

    }

}
package uebung03;

import uebung02.BinaryTree.IntElement;
import uebung02.QickSort.StatObject;
import uebung03.Elements.StringElement;

import static gdi.MakeItSimple.print;
import static pr.MakeItSimple.println;

public class Intersort implements SortInterface {


    public static void main(String args[]){
        //uebung02.BinaryTree.IntElement array[] = {new uebung02.BinaryTree.IntElement(10), new uebung02.BinaryTree.IntElement(7), new uebung02.BinaryTree.IntElement(1), new uebung02.BinaryTree.IntElement(97), new uebung02.BinaryTree.IntElement(14), new uebung02.BinaryTree.IntElement(2), new uebung02.BinaryTree.IntElement(1),new uebung02.BinaryTree.IntElement(100) };
        Comparable array[] = {new StringElement("Aaaa"), new StringElement("Aaaca"), new StringElement("fdgfd"), new StringElement("gahtaa"), new StringElement("Bfgd"), new StringElement("000")};
        SortInterface.sortArray(array, new Intersort());
        print("\n");
        for(Comparable t : array)
            print(" " + (String)((StringElement)t).getKey());
    }
    @Override
    public void sort(Comparable[] array, int u, int o) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            Comparable m = array[i];
            while (j > 0 && array[j - 1].compareTo(m) < 0 ) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = m;
        }
    }

    @Override
    public void sort(Comparable[] F, StatObject so) {
        this.sort(F, 0, F.length - 1);
    }

    @Override
    public int split(Comparable[] F, int u, int o) {
        return 0;
    }

    @Override
    public void swap(Comparable[] F, int i1, int i2) {

    }
}

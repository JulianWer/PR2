package uebung02.QickSort;
import uebung02.BinaryTree.IntElement;

import static gdi.MakeItSimple.*;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class QuickSort  {
	StatObject so; // statistics collection

	public static void main(String args[]){
		IntElement array[] = {new IntElement(10), new IntElement(7), new IntElement(1), new IntElement(97), new IntElement(14), new IntElement(2), new IntElement(1),new IntElement(100) };
		new QuickSort().sort(array, new StatObject());
		for(Comparable t : array)
			print(" " + ((IntElement) t).getValue());
	}


	public void sort(Comparable[] F, StatObject so) { // overloaded sort method for testing with parameters of an array and StatObject
		// TODO Auto-generated method stub
		this.so = so; // set StatObject to the attribute of itself
		sort(F, 0, F.length - 1); // call the normal sort method

	}


	public void sort(Comparable[] array, int lowerLimit, int upperLimit) {
		
		if(array.length <= 1) so.incrunCounter();

		if (upperLimit > lowerLimit) { // runs as long as the upper cabinets is greater than the under
			so.incrunCounter();// count runs for statistics
			//println("upperlimit is higher than lowerlimit");
			int splitIndex = split(array, lowerLimit, upperLimit); // call split method and write the index to splitIndex
			sort(array, lowerLimit, splitIndex); // call method recursive 
			sort(array, (splitIndex + 1), upperLimit);
		}
	}


	public int split(Comparable[] array, int lowerLimit, int upperLimit) { // sorts elements in direction of the middle element
		// TODO Auto-generated method stub
		int pivotIndex = (lowerLimit + upperLimit) / 2; // set pivotIndex to the middle
		Comparable pivot = array[pivotIndex]; // set middle element of the array to the pivot element
		

		
		while (lowerLimit <= upperLimit) { // run as long as upper is greater than lower
			
		
			// for loop loops as long as i is smaller than upperLimit +1 and the boolean found is false
			int l = lowerLimit;
			so.inccomparisonCounter();
			//while(array[l] < pivot) {
			while(array[l].compareTo(pivot) < 0){
				l++;
				//if (array[l] <= pivot)
			if (array[l].compareTo(pivot) == 0 || array[l].compareTo(pivot) < 0)
					so.inccomparisonCounter();
			}
			int r = upperLimit;
			so.inccomparisonCounter();
			//while(array[r] > pivot) {
			while(array[r].compareTo(pivot) > 0) {
				r--;
				//if(array[r] >= pivot)
				if(array[r].compareTo(pivot) > 0 || array[r].compareTo(pivot) == 0)
					so.inccomparisonCounter(); // TODO abweichung um 1
			}
			

			if (l < r) {
				swap(array, r, l); // call swap method with array, r and l
				so.incswapCounter(); // count swaps 
				lowerLimit = l + 1; // add one to l and write it in lowerLimit
				upperLimit = r - 1;
			} else {
				return r;
			}
		}
		
		for (Comparable i : array) { // output after every run
			print(i + " ");
		}
		println();

		return upperLimit;
	}


	public void swap(Comparable[] array, int r, int l) { // swap elements of array
		// TODO Auto-generated method stub
		Comparable temp = array[r]; // create temporary variable "temp"
		array[r] = array[l];
		array[l] = temp;
	}

}

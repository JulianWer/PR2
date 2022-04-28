package uebung02.QickSort;
import static gdi.MakeItSimple.*;

/**
 * @author Johannes , Julian
 * @since 2022-04
 */

public class QuickSort implements SortInterface {
	StatObject so; // statistics collection

	@Override
	public void sort(int[] F, StatObject so) { // overloaded sort method for testing with parameters of an array and StatObject
		// TODO Auto-generated method stub
		this.so = so; // set StatObject to the attribute of itself
		sort(F, 0, F.length - 1); // call the normal sort method

	}

	@Override
	public void sort(int[] array, int lowerLimit, int upperLimit) {
		System.out.println(upperLimit);
		System.out.println(lowerLimit);

		if (upperLimit > lowerLimit) { // runs as long as the upper cabinets is greater than the under
			so.incrunCounter();// count runs for statistics
			println("upperlimit is higher than lowerlimit");
			int splitIndex = split(array, lowerLimit, upperLimit); // call split method and write the index to splitIndex
			sort(array, lowerLimit, splitIndex); // call method recursive 
			sort(array, (splitIndex + 1), upperLimit);
		}
	}

	@Override
	public int split(int[] array, int lowerLimit, int upperLimit) { // sorts elements in direction of the middle element
		// TODO Auto-generated method stub
		int pivotIndex = (lowerLimit + upperLimit) / 2; // set pivotIndex to the middle
		int pivot = array[pivotIndex]; // set middle element of the array to the pivot element 
		println("Pivot: " + pivot);

		int l = upperLimit, r = lowerLimit;
		while (lowerLimit <= upperLimit) { // run as long as upper is greater than lower

			boolean found = false; // set boolean found to false
			// for loop loops as long as i is smaller than upperLimit +1 and the boolean found is false
			for (int i = lowerLimit; (i < (upperLimit + 1) && !found); i++) { 
				so.inccomparisonCounter(); // count comparison Counter one up
				if (array[i] >= pivot) { // compare values of index i and pivot element  
					found = true; 
					l = i; // set l to the value of i 
				}
			}
			found = false;
			// for loop loops as long as i is smaller than lowerLimit +1 and the boolean found is false
			for (int i = upperLimit; (i > (lowerLimit - 1) && !found); i--) {
				so.inccomparisonCounter();
				if (array[i] <= pivot) {// compare values of index i and pivot element  
					found = true;
					r = i;
				}
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

		return upperLimit;
	}

	@Override
	public void swap(int[] array, int r, int l) { // swap elements of array
		// TODO Auto-generated method stub
		int temp = array[r]; // create temporary variable "temp" 
		array[r] = array[l];
		array[l] = temp;
	}

}

package uebung02;

public class QuickSort {
	
	
	
	public void quicksort(int[] array, int lowerLimit, int upperLimit) {
		System.out.println(upperLimit);
		System.out.println(lowerLimit);
		
		if(upperLimit > lowerLimit) {
			System.out.println("upperlimit is higher than lowerlimit");
			int splitIndex = split(array, lowerLimit, upperLimit);
			quicksort(array, lowerLimit, splitIndex);
			quicksort(array, (splitIndex+1), upperLimit);
		}
	}

	private int split(int[] array, int lowerLimit, int upperLimit) {	// Ordnet F bzgl. des mittleren Elements
		// TODO Auto-generated method stub
		int pivotIndex = (lowerLimit + upperLimit) / 2;
		int pivot = array[pivotIndex];
		System.out.println("Pivot: " + pivot);
		
		int l = upperLimit, r = lowerLimit;
		while(lowerLimit <= upperLimit) {
			
			boolean found = false;
			for(int i = lowerLimit; (i < (upperLimit + 1) && !found); i++) {
				if(array[i] >= pivot) {
					found = true;
					l = i;
				}
			}
			found = false;
			for(int i = upperLimit; (i > (lowerLimit - 1) && !found); i--) {
				if(array[i] <= pivot) {
					found = true;
					r = i;
				}
			}
			
			if(l < r) {
				int help = array[r];
				array[r] = array[l];
				array[l] = help;
				lowerLimit = l + 1;
				upperLimit = r - 1;
			}else {
				return r;
			}
		}
		
		
		return upperLimit;
	}

}

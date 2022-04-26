package uebung02;

public class QuickSortV2 {
	public void quicksort(int[] array, int lowerLimit, int upperLimit) {
		System.out.println(upperLimit);
		System.out.println(lowerLimit);
		
		if(upperLimit > lowerLimit) {
			System.out.println("upperlimit is higher than lowerlimit");
			int splitIndex = split(array, lowerLimit, upperLimit);
			quicksort(array, lowerLimit, splitIndex - 1);
			quicksort(array, (splitIndex+1), upperLimit);
		}
	}

	private int split(int[] array, int lowerLimit, int upperLimit) {
		// TODO Auto-generated method stub
		
		int l = upperLimit, r = lowerLimit;
		int pivot = array[upperLimit];
		while(lowerLimit <= upperLimit) {
			
			boolean found = false;
			for(int i = lowerLimit; (i < (upperLimit + 1) && !found); i++) {
				if(array[i] > pivot) {
					found = true;
					l = i;
				}
			}
			if(!found)
				l = upperLimit;
			found = false;
			for(int i = upperLimit - 1; (i > (lowerLimit - 1) && !found); i--) {
				if(array[i] <= pivot) {
					found = true;
					r = i;
				}
			}
			if(!found)
				r = lowerLimit - 1;
				
			if(l < r) {
				//swap
				int help = array[r];
				array[r] = array[l];
				array[l] = help;
				lowerLimit = l + 1;
				upperLimit = r;
			}else {
				int help = array[upperLimit];
				array[upperLimit] = array[l];
				array[l] = help;
				return l;
			}
		}
		int help = array[lowerLimit];
		array[lowerLimit] = array[upperLimit];
		array[upperLimit] = help;
		return lowerLimit;
	}

}

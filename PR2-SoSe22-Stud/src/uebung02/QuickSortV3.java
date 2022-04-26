package uebung02;

/**
 * @author Johannes
 * @author Julian
 */

public class QuickSortV3 implements SortInterface{

	@Override
	public int[] sort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int split(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] swap(int i1, int i2) {
		// TODO Auto-generated method stub
		int remember =  i1;
		i1 = i2;
		i2 = remember;
		int[] array = {i1,i2};
		return array;
	}

}

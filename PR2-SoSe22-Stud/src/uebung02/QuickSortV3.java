package uebung02;

/**
 * @author Johannes
 * @author Julian
 */

public class QuickSortV3 implements SortInterface{

	@Override
	public void sort(int[] F , int u, int o) {
		// TODO Auto-generated method stub
		if(o> u) {
			int i = split(F,u,o);
			sort(F,u,i);
			sort(F,i+1,o);
		}
		
	}

	@Override
	public int split(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		int[] array;
		int p = o;
		int index = u;
		for (int zeiger = u; zeiger < o-1; zeiger++) {
			if(F[zeiger] <= F[p]) {
				array = swap(F[index],F[zeiger]);
				F[index] = array[0];	
				index ++;
			}
		}
		array = swap(F[index],F[p]);
		F[index] = array[0];
		F[p] = array[1];
		
		return index;
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

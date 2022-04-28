package uebung02;
import static gdi.MakeItSimple.*;
/**
 * @author Johannes
 * @author Julian
 */

public class QuickSortV3 implements SortInterface{
	StatObject so;
	
	public void sort(int[] F , StatObject so) {
		// TODO Auto-generated method stub
		this.so = so;
		sort(F,0, F.length-1);
		
	}

	public void sort(int[] F , int u, int o) {
		// TODO Auto-generated method stub
		if(o > u) {
			so.incrunCounter();
			int i = split(F,u,o);
			sort(F,u,i-1);
			sort(F,i+1,o);
		}
		
	}

	@Override
	public int split(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		
		int p = o;
		int index = u;
		for (int zeiger = u; zeiger <= o-1; zeiger++) {
			so.inccomparisonCounter();
			if(F[zeiger] <= F[p]) {
				
				println(F[index] +" "+ F[zeiger]);
				if(zeiger !=index)
					swap(F, index,zeiger);
				index ++;
				//println(F[index] +" "+ F[zeiger]);
			}
		}
		if(index != o)
			swap(F,index ,p);
		
		
		return index;
	}

	@Override
	public void swap(int[] F,int i1, int i2) {
		// TODO Auto-generated method stub
		so.incswapCounter();
		int remember =  F[i1];
		F[i1] = F[i2];
		F[i2] = remember;
		
		
	}

}

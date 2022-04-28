package uebung02.QickSort;

public class QuickSortV2 implements SortInterface {

	public static void main(String[] args) {
		int array[] = new int[] {44,6,55,30,94,18};
		new QuickSortV2New().sort(array, 0,(array.length-1));
		
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");

	}

	@Override
	public void sort(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		if(o > u) {
			int i = split(F, u, o);
			sort (F, u, i-1);
			sort (F, i+1, o);
		}
		
	}

	@Override
	public void sort(int[] F, StatObject so) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int split(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		int p = o;
		int piv = F[p];
		int l = 0, r = 0;
		while(u <= o) {
			boolean finish = false;
			for(int i = u; (i < o && !finish); i++) {
				if(F[i] > piv) {
					l = i;
					finish = true;
				}
			}
				finish = false;
			for(int i = (o - 1); (i > u && !finish); i--){
				if(F[i] <= piv) {
					r = i;
					finish = true;
				}	
			}
		if(l < r) {
			int i = F[r];
			F[r] = F[l];
			F[l] = i;
			u = l + 1;
			o = r - 1;
		}else {
			int i = F[p];
			F[p] = F[l];
			F[l] = i;
			return l;
		}
			
		}
		int i = F[p];
		F[p] = F[u];
		F[u] = i;
		
		return o;
	}

	@Override
	public void swap(int[] F, int i1, int i2) {
		// TODO Auto-generated method stub
		
	}

}

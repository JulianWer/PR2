/**
 * 
 */
package uebung02;

/**
 * @author Johannes
 * @author Julian
 */
public interface SortInterface {
	
	public void sort(int[] F , int u, int o); 
	public void sort(int[] F , StatObject so);
	public int split(int[] F , int u, int o); 
	public void swap(int[] F ,int i1 , int i2);
	
}

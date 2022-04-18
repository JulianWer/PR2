package uebung01;

import AB1.NatuerlicherMergeSort;
import AB1.StraightMergeSort;
import AB1.direkterMergesort;

public class MergeSort {
	
	public void naturalMergeSort(String inputfile, String outputfile) {
		NatuerlicherMergeSort.natuerlicherMergeSort(inputfile, outputfile);
	}
	
	public void straightMergeSort(String inputfile, String outputfile) {
		//direkterMergesort.direktMerge(inputfile, outputfile);
		new StraightMergeSort().sort(inputfile, outputfile);
	}

}

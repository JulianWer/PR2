package uebung01;

public class MergeSort {
	
	public void naturalMergeSort(String inputfile, String outputfile) {
		NatuerlicherMergeSort.natuerlicherMergeSort(inputfile, outputfile);
	}
	
	public void straightMergeSort(String inputfile, String outputfile) {
		//direkterMergesort.direktMerge(inputfile, outputfile);
		new StraightMergeSort().sort(inputfile, outputfile);
	}

}

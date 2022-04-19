package uebung01;

public class MergeSort {
	
	public void naturalMergeSort(String inputfile, String outputfile) {
		NatuerlicherMergeSort.natuerlicherMergeSort(inputfile, outputfile);
	}
	
	public void straightMergeSort(String inputfile, String outputfile) {
		//direkterMergesort.direktMerge(inputfile, outputfile);
		DirekterMergesort dm = new DirekterMergesort();
		dm.runMergeSort("C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers03.txt","C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
	}

}

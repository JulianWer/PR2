package AB1;

import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.closeOutputFile;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.openOutputFile;
import static gdi.MakeItSimple.println;

public class direkterMergesort {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void sort(String path) {
		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		
		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return;
		}

		Object tape0 = openInputFile(tape_0);
		Object tape1 = openOutputFile(tape_1);
		Object tape2 = openOutputFile(tape_2);
		
		while (!isEndOfInputFile(tape0)){
			
		}
		
		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
	}

}

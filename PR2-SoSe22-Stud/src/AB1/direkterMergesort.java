package AB1;

import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.closeOutputFile;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.openOutputFile;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.*;
import static pr.MakeItSimple.*;

public class direkterMergesort {
	public static int durch = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt");

	}
	
	public static void sort(String path) {
		durch++;
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
		boolean tb = true;
		int d = durch;
		int l = 1;
		while (!isEndOfInputFile(tape0)){
			int in = readInt(tape0);
			if(tb) {
				print(tape1, in + " ");
				if(l == d) {
					tb = !tb;
					l=1;
					continue;
				}
				
			}
			else
				print(tape2,in+ " ");
				if(l == d) {
					tb = !tb;
					l = 1;
					continue;
					}
			l++;
					
				
			
			
			
		}
		
		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
	}
	
	public static void merge(String path) {
		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		Object tape0 = openOutputFile(tape_0);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		
		
		
	}
	
	

}

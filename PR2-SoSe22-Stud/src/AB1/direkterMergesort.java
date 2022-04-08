package AB1;

import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.closeOutputFile;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.openOutputFile;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;

import java.util.ArrayList;

public class direkterMergesort {
	public static int durchL = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt");
		merge("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");
		//sort("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");

	}

	public static void sort(String path) {
		durchL++; // zählvariable für insgesamt durchläufe
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
		int d = durchL;
		int l = 1;
		while (!isEndOfInputFile(tape0)) {
			int in = readInt(tape0);
			if (tb) {
				print(tape1, in + " ");
				if (l == d) {
					tb = !tb;
					l = 1;
					continue;
				}

			} else {
				print(tape2, in + " ");
				if (l == d) {
					tb = !tb;
					l = 1;
					continue;
				}
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
		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return;
		}
		Object tape0 = openOutputFile(tape_0);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		int dl = durchL;
		int in1 = 0;
		int in2 = 0;
		boolean lb = true;
		
		int[] array1 = new int[dl];
		int[] array2 = new int[dl];

		while (!isEndOfInputFile(tape1) || !isEndOfInputFile(tape2)) {

			try {
				for(int i = 0 ; i<array1.length ;i++)
					array1[i] = readInt(tape1);
				for(int j = 0; j<array2.length; j++)
					array2[j] = readInt(tape2);
				
			} catch (Exception e) {
				return;
			}
			
			for(int i = 0 ; i<array1.length ;i++) {
				for(int j = 0; j<array2.length ; j++) {
					if(array1[i] > array2[j]) {
						print(tape0, array2[j] + " ");
						print(tape0, array1[i] + " ");
						
					}
					else {
						print(tape0, array1[i] + " ");
						print(tape0, array2[j] + " ");
					}
					
						
				}
			}
			
			
			

		}
		closeInputFile(tape1);
		closeInputFile(tape2);
		closeOutputFile(tape0);

	}

}

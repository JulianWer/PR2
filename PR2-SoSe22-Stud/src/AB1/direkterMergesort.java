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
		split("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt");
		merge("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");
		split("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");
		merge("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");
		split("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");
		//merge("C:\\Users\\julia\\git\\Team-03o\\PR2-SoSe22-Stud\\mergeMethodTest");
		

	}

	public static void split(String path) {
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
		int in = 0;
		while (!isEndOfInputFile(tape0)) {
			try {
				in = readInt(tape0);
				
			}catch(Exception e) {
				closeInputFile(tape0);
				closeOutputFile(tape1);
				closeOutputFile(tape2);
				println("fehler");
				return;
			}
			if(l == d+1) {
				l = 1;
				tb = !tb;
			}
			if (tb) {
				print(tape1, in + " ");
				

			} else {
				print(tape2, in + " ");
				
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
		
		
		

		while (!isEndOfInputFile(tape1) || !isEndOfInputFile(tape2)) {
			int[] array = new int[dl*2];

			try {
				for(int i = 0 ; i<array.length/2 ;i++)
					array[i] = readInt(tape1);
				for(int j = array.length/2; j<array.length; j++)
					array[j] = readInt(tape2);
				
			} catch (Exception e) {
				closeInputFile(tape1);
				closeInputFile(tape2);
				closeOutputFile(tape0);
				return;
			}
			
			for(int i = 0 ; i<array.length ;i++) {
				for(int j = 0; j<array.length ; j++) {
					if(array[i] <array[j]) {
						int zwisch = array[j];
						array[j] = array[i];
						array[i] = zwisch;
					}
					
						
				}
			}
			for(int i : array) {
				print(tape0,i+" ");
			}
			
			
			

		}
		closeInputFile(tape1);
		closeInputFile(tape2);
		closeOutputFile(tape0);

	}

}

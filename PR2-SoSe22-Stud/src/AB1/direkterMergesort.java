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

	
	
	public  void direktMerge(String src ,String path) {
		split(src);
		merge(path);
		do {
			split(path);
			merge(path);
		}while(checkRun(path));
		split(path);
		merge(path);
		split(path);
		merge(path);
	}
	
	public  boolean checkRun(String path) {
		int array[] = new int[100];
		int in =0;
		boolean check = true;
		Object tape0 = openInputFile(path);
		while (!isEndOfInputFile(tape0)) {
			try {
				for(int i = 0 ; i<array.length ;i++)
					array[i] = readInt(tape0);
				
			}catch(Exception e) {
				closeInputFile(tape0);
				println("fehler");
				return false;
			}
			
			for(int i :array) {
				if (array[i]> array[i-1]) {
					check = false;
				}
				else { 
					return true;
				}
			}
		}
		closeInputFile(tape0);
		return check;
	}

	public  void split(String path) {
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
		if(durchL%2 != 0 && durchL !=1)
			durchL+=1;
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
				print(tape1, " " +in);
				

			} else {
				print(tape2, " " +in);
				
			}
			l++;

		}

		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
	}

	public void merge(String path) {
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
		int res = 0;
		boolean lb = true;
		
		
		

		while (!isEndOfInputFile(tape1) || !isEndOfInputFile(tape2)) {
			
				for(int i = 0; i< dl*2;i++) {
						in1 = readInt(tape1);
						in2 = readInt(tape2);
						
						if(in1< in2 && in1<res) {
							println(tape0,in1);
							res = in2;
						}
						else if(in2 < in1 && in2<res) {
							println(tape0,in2);
							res = in1;
						}
				}
					
					
						
					
					
					
				
			
			
		
			
			
		}
		closeInputFile(tape1);
		closeInputFile(tape2);
		closeOutputFile(tape0);

	}
	
	public void merge(int runlength, String path){
		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return;
		}
		Object target = openOutputFile(tape_0);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		
		//decide which run is smaller
		int cntElementsReadTape1 = 0;
		int cntElementsReadTape2 = 0;
		int currentElementTape1 = 0;
		int currentElementTape2 = 0;
		boolean firstRun = true;
		
		
		while(cntElementsReadTape1 != runlength && cntElementsReadTape2 != runlength){
			if(firstRun) {
				currentElementTape1 = readInt(tape1);
				currentElementTape2 = readInt(tape1);
				cntElementsReadTape1++;
				cntElementsReadTape2++;
				firstRun = false;
				
				if(currentElementTape1 <= currentElementTape2) {
					print(target, currentElementTape1);
					currentElementTape1 = readInt(tape1);
					cntElementsReadTape1++;
					continue;
				}else {
					print(target, currentElementTape2);
					currentElementTape2 = readInt(tape2);
					cntElementsReadTape2++;
					continue;
				}
				
			
			}
			
		if((currentElementTape1 <= currentElementTape2 && cntElementsReadTape1 < runlength) || (cntElementsReadTape2 == runlength && cntElementsReadTape1 < runlength)) {
			//print current element from tape1
			print(target, " " + currentElementTape1);
			currentElementTape1 = readInt(tape1);
			cntElementsReadTape1++;
			continue;
		}
		if((currentElementTape2 < currentElementTape1 && cntElementsReadTape2 < runlength) || (cntElementsReadTape1 == runlength && cntElementsReadTape2 < runlength)) {
			//print current element from tape1
			print(target, " " + currentElementTape2);
			currentElementTape2 = readInt(tape2);
			cntElementsReadTape2++;
			continue;
		}
			
		}
		
		
		//compare both elements
		
		
		//solange wiederholen bis beide Tapes keine Elemente mehr beeinhalten.
		
	}

//	public void merge(int runlength){
//		//decide which run is smaller
//		
//		while( ...bis beide Tapes keine Elemente mehr beeinhalten)
//		currentElementTape1 = readInt(tape1);
//		currentElementTape2 = readInt(tape2);
//		
//		if(currentElementTape1 <= currentElementTape2){
//			//add run from tape1 to traget tape
//			print(target, currentElementTape1);
//			for(int i = 0; i < (runlength - 1); i++){	//(runlength - 1) because first element is already printed to the target	
//				currentElementTape1 = readInt(tape1);
//				print(target, " " + currentElementTape1);
//			}
//		}else{
//			//add run from tape1 to traget tape
//			print(target, currentElementTape2);
//			for(int i = 0; i < (runlength - 1); i++){
//				currentElementTape2 = readInt(tape2);
//				print(target, " " + currentElementTape2);
//			}
//			
//		}
//		
//		//solange wiederholen bis beide Tapes keine Elemente mehr beeinhalten.
//		
//	}
}
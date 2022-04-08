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
import static pr.MakeItSimple.*;


public class NatuerlicherMergeSort {

	public static void main(String[] args) {
	
		natuerlicherMergeSort("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt", "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");

		
		
	}
	
	public static void natuerlicherMergeSort(String srcFile, String newFile) {
		//first run
		split(srcFile);
		merge();
		do {
			split(newFile);
			merge();
			
		}while(checkIfFileHasMoreThanOneRun(newFile));
	}
	
	public static void split(String path) {
		//runs mit maximaler Lauflänge erstellen
		//Tape0 aufteilen
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
		
		boolean writeToTape1 = true;
		int lastInputNumber = 0;
		int currentNumber = 0;
		int cnt = 0;
		
		while(!isEndOfInputFile(tape0)) {
			if(cnt == 0) {
				currentNumber = readInt(tape0);	//Initialisierung
				print(tape1, currentNumber + " ");
				lastInputNumber = currentNumber;
				cnt++;
				continue;
			}
			
			try {
				currentNumber = readInt(tape0);
			}catch (Exception e) {
				// TODO: handle exception
				closeInputFile(tape0);
				closeOutputFile(tape1);
				closeOutputFile(tape2);
				return;
			}
			
			if(currentNumber < lastInputNumber)
				writeToTape1 = !writeToTape1;
			
			if(writeToTape1) {
				print(tape1, currentNumber + " ");
			}else {
				print(tape2, currentNumber + " ");
			}
			lastInputNumber	= currentNumber;
			cnt++;
			
		}
		
		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
	}
	
	public static void merge() {
		//tape0 überschreiben
		//solange tape1 & tape2 einen Lauf enthalten
		// => Füge das kleinere Anfangselement an tape0 hinzu
		
		String tape_0 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt";
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		String sorted_tape = "mergeMethodTest";

		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return;
		}
		
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		Object sortedTape = openOutputFile(sorted_tape);
		
		//Initialwerte
		int currentElementTape1 = readInt(tape1);
		int currentElementTape2 = readInt(tape2);
		
		boolean tape1ContainsRuns = true;
		boolean tape2ContainsRuns = true;
		
		while(tape1ContainsRuns || tape2ContainsRuns) {	//solange die Runs noch nicht abgearbeitet sind
			//append smaller element
			if(((currentElementTape1 <= currentElementTape2) && tape1ContainsRuns) || (tape1ContainsRuns && !tape2ContainsRuns)) {
				print(sortedTape, currentElementTape1 + " ");
				
				
				if(!isEndOfInputFile(tape1)) {
					try {
						currentElementTape1 = readInt(tape1);
					}catch(Exception e) { tape1ContainsRuns = false; }
					
				}else {
					tape1ContainsRuns = false;
				}
				
				
			}
			if((currentElementTape2 < currentElementTape1 && tape2ContainsRuns) || (!tape1ContainsRuns && tape2ContainsRuns)) {
				//currentelement from tape2 is smaller
				print(sortedTape, currentElementTape2 + " ");
				
				if(!isEndOfInputFile(tape2)) {
					try {
						currentElementTape2 = readInt(tape2);
					}catch(Exception e) {tape2ContainsRuns = false;}
				}else {
					tape2ContainsRuns = false;
				}
				
			}
			
		}
		
		closeInputFile(tape1);
		closeInputFile(tape2);
		closeOutputFile(sortedTape);
	}
	
	public static boolean checkIfFileHasMoreThanOneRun(String path) {
		Object tape0 = openInputFile(path);
		int lastElement = readInt(tape0);
		while(!isEndOfInputFile(tape0)) {
			try {
				int currentElement = readInt(tape0);
				if(lastElement > currentElement) {
					closeInputFile(tape0);
					return true;
				}
			}catch(Exception e) {
				closeInputFile(tape0);
				return false;
			}
		}
		return false;
	}
}

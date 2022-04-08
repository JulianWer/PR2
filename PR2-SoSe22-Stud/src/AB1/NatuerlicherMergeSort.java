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
		split();
		merge();
		

	}
	
	public static void split() {
		//runs mit maximaler Lauflänge erstellen
		//Tape0 aufteilen
		String tape_0 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt";
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
		int cnt = 0;
		
		while(!isEndOfInputFile(tape0)) {
			if(cnt == 0) {
				int currentNumber = readInt(tape0);	//Initialisierung
				print(tape1, currentNumber + " ");
				lastInputNumber = currentNumber;
				cnt++;
				continue;
			}
			
			int currentNumber = readInt(tape0);
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
		
		while(tape1ContainsRuns || tape2ContainsRuns) {
			//append smaller element
			if((currentElementTape1 <= currentElementTape2 && tape1ContainsRuns) || (tape1ContainsRuns && !tape2ContainsRuns)) {
				print(sortedTape, currentElementTape1 + " ");
				
				
				if(!isEndOfInputFile(tape1)) {
					currentElementTape1 = readInt(tape1);
				}else {
					tape1ContainsRuns = false;
				}
				
				
			}else if(tape2ContainsRuns) {
				//currentelement from tape2 is smaller
				print(sortedTape, currentElementTape2 + " ");
				
				if(!isEndOfInputFile(tape2)) {
					currentElementTape2 = readInt(tape2);
				}else {
					tape2ContainsRuns = false;
				}
				
			}
			
		}
		
		
	}

}

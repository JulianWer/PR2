package uebung01;

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

		//natuerlicherMergeSort("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt",
		//		"C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
		natuerlicherMergeSort("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt",
				"C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
	}
	
	

	public static void natuerlicherMergeSort(String srcFile, String newFile) {
		// first run
		int output[] = split(srcFile);
		merge(newFile);
		
		while(output[0] != 1) {
			output = split(newFile);
			merge(newFile);
		}
		
	}


	public static int[] split(String path) {
		// runs mit maximaler Lauflänge erstellen
		// Tape0 aufteilen
		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";

		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return new int[] {-1, -1, -1};
		}

		Object tape0 = openInputFile(tape_0);
		Object tape1 = openOutputFile(tape_1);
		Object tape2 = openOutputFile(tape_2);

		boolean writeToTape1 = true;
		int lastInputNumber = 0;
		int currentNumber = 0;
		int cnt = 0;
		int cnt2 = 0;
		int runs = 0;

		while (!isEndOfInputFile(tape0)) {
			if (cnt == 0) {
				currentNumber = readInt(tape0); // Initialisierung
				print(tape1, currentNumber);
				lastInputNumber = currentNumber;
				cnt++;
				runs++;
				continue;
			}

			
			currentNumber = readInt(tape0);	//Nächste Zahl einlesen
			

			if (currentNumber < lastInputNumber) {
				writeToTape1 = !writeToTape1;
				runs++;
			}

			if (writeToTape1) {
				print(tape1, " " + currentNumber);
				cnt++;
			} else {
				if(cnt2 == 0) {
					print(tape2, currentNumber);
					cnt2++;
					
				}else {
					print(tape2, " " + currentNumber);
					cnt2++;
				}
			}
			lastInputNumber = currentNumber;
			

		}

		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
		
		return new int[]{runs, cnt, cnt2};	//runs Anzahl der Runs insgesamt, cnt Anzahl der Element in tape1, cnt2 Anzahl der Elemente in tape2
	}
	
	public static void merge(String path) {
		String targetpath = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";

		if (!isFilePresent(targetpath)) {
			println(targetpath + " existiert nicht ");
		}

		Object target = openOutputFile(targetpath);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		int numberTape1 = 0, numberTape2 = 0;
		
		boolean firstRun = true;
		boolean tape1ContainsNumbers = true;
		boolean tape2ContainsNumbers = true;
	
		if(firstRun) {
			//Startwerte initialisieren
			if(!isEndOfInputFile(tape1)) {
				numberTape1 = readInt(tape1);
			}else {
				tape1ContainsNumbers = false;
			}
			
			if(!isEndOfInputFile(tape2)) {
				numberTape2 = readInt(tape2);
			}else {
				tape2ContainsNumbers = false;
			}
		}
		
	while(tape1ContainsNumbers || tape2ContainsNumbers) {
		if((numberTape1 <= numberTape2 && tape1ContainsNumbers) || !tape2ContainsNumbers) {
			//add number from tape1 to target
			if(firstRun) {
				print(target, numberTape1);
				firstRun = false;
			}else {
				print(target, " " + numberTape1);
			}
			if(!isEndOfInputFile(tape1)) {
				numberTape1 = readInt(tape1);
				System.out.println(numberTape1);
			}else {
				tape1ContainsNumbers = false;
			}
			continue;
		}
		
		if((numberTape2 < numberTape1 && tape2ContainsNumbers) || !tape1ContainsNumbers) {
			if(firstRun) {
				print(target, numberTape2);
				firstRun = false;
			}else {
				print(target, " " + numberTape2);
			}
			if(!isEndOfInputFile(tape2)) {
				numberTape2 = readInt(tape2);
				System.out.println(numberTape2);
			}else {
				tape2ContainsNumbers = false;
			}
			continue;
		}
		
	}
	
	closeInputFile(tape1);
	closeOutputFile(target);
	closeInputFile(tape2);
	}
	public static boolean checkIfFileHasMoreThanOneRun(String path) {
		Object tape0 = openInputFile(path);
		int lastElement = readInt(tape0);
		while (!isEndOfInputFile(tape0)) {
			try {
				int currentElement = readInt(tape0);
				if (lastElement > currentElement) {
					closeInputFile(tape0);
					return true;
				}
			} catch (Exception e) {
				closeInputFile(tape0);
				return false;
			}
		}
		return false;
	}
}

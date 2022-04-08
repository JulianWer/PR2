package uebung01;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;
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

import org.junit.Test;

import AB1.NatuerlicherMergeSort;

public class MergeSort1stTests {

	/*
	 * @Test public void test() { fail("Not yet implemented"); }
	 */

	@Test
	public void natuerlicherMergeSortTest() {
		//Testfaelle für die inputFiles
		String path1 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt";
		String path2 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt";
		String path3 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers03.txt";
		String pathForTestFile = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest";
		String paths[] = {path1, path2, path3};
		
		for (String path : paths) {
			NatuerlicherMergeSort.natuerlicherMergeSort(path, pathForTestFile);
			
			Object file = openInputFile("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
			int lastElement = readInt(file);
			try {
				while(!isEndOfInputFile(file)) {
					int currentElement = readInt(file);
					if(lastElement > currentElement)
						fail("Falsche Reihenfolge => Algorithmus ist fehlerhaft");
					lastElement = currentElement;
				}
			}catch (Exception e) {
				assumeTrue("Algorithmus korrekt, alle Elemente in der richtigen Reihenfolge", true);
			}
			assumeTrue("Algorithmus korrekt, alle Elemente in der richtigen Reihenfolge", true);	//wird erst ausgeführt, wenn alle Element an der korrekten Position stehen
			//checkIfCorrectSorted
		}
		
		
		
		
		
	}
}

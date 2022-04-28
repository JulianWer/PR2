package uebung02;
import static gdi.MakeItSimple.*;

import java.lang.reflect.Array;

public class QickSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UI();
	}
	private static void UI() {
		print("Welcome, please Enter the file to sort:");
		String filePath = readLine();
		while(!isFilePresent(filePath)) {
			println();
			print("File is not present please enter another one");
			filePath = readLine();
		}
		int[] arrayF = readFromFile(filePath);
		println();
		println("Which qicksort do you want to use?");
		print("qicksort variant 1 - v1 \nqicksort variant 2 - v2 \nqicksort variant 3 - v3 \nType in here: ");
		switch(readLine()) {
		case "v1":
			QuickSort sq = new QuickSort();
			sq.sort(arrayF,0, Array.getLength(arrayF));
		case "v2":
			QuickSortV2 sq2 = new QuickSortV2();
			sq2.sort(arrayF,0, Array.getLength(arrayF));
		case "v3":
			QuickSortV3 sq3 = new QuickSortV3();
			sq3.sort(arrayF,0, Array.getLength(arrayF));
		}
	}
	
	private static int[] readFromFile(String ipath) {
		Object in = openInputFile(ipath);
		int[] array = new int[readLine(in).length()];
		Object file = openInputFile(ipath);
		for (int i = 0; !isEndOfInputFile(ipath); i++) {
			array[i] = readInt(file);
		}
		closeInputFile(file);
		closeInputFile(in);
		return array;
		
	}

}

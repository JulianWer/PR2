package uebung03;
import scala.Int;
import uebung03.Elements.Element;
import uebung03.Elements.IntElement;
import uebung03.Elements.StringElement;

import static gdi.MakeItSimple.*;


public class UI {

    Comparable[] cArray = new Comparable[1];
    SortInterface sortAlgorithm;

    public void menu(){


        print("Welches Sortierverfahren wollen Sie verwinden? ");
        String sortCase = readLine();
        if(sortCase.equalsIgnoreCase("QuickSort")){
            this.sortAlgorithm = new QuickSortV3();
        }
        if(sortCase.equalsIgnoreCase("InsertionSort")){
            this.sortAlgorithm = new Intersort();
        }
        print("What kind of element do you want to read in? int/str ");
        String element = readLine();


        String check;
        int indexcnt = 0;

        do{
            dynamic(indexcnt);
            if(element.equals("str")){
                cArray[indexcnt] = new StringElement(readLine());


            }else if(element.equals("int")){
                cArray[indexcnt] = new IntElement(readInt());
                for(Comparable t : cArray)
                    print(" " + ((IntElement)t).getKey());
            }
            println("Do you want to add another items? y/n");
            do {
                check = readLine();
            }while (check.isBlank() || check.isEmpty());
            indexcnt++;
        }while(check.equals("y"));

        printArray(cArray);
        println("Sorted Array: ");
        SortInterface.sortArray(cArray, this.sortAlgorithm);
        println("Sorted Array: ");
        printArray(cArray);
    }

    public void dynamic(int index){
        if (index >= cArray.length){
            Comparable[] newArray = new Comparable[index+1];
            for (int i = 0; i < cArray.length; i++) {
                newArray[i] = cArray[i];
            }
            cArray = newArray;
        }
    }

    private void printArray(Comparable array[]){
        for(Comparable i : array){
            if(i instanceof IntElement){
                print(" " + ((IntElement)i).getKey());
            }
            if(i instanceof StringElement)
                print( ((StringElement)i).getKey() + " ");
        }

    }


}

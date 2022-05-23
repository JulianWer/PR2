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


        print("Welches Sortierverfahren wollen Sie verwinden? \nq-QickSortV3 \ni-InterSort \nPlease type in here: ");
        String sortCase = readLine();
        if(sortCase.equalsIgnoreCase("q")){
            this.sortAlgorithm = new QuickSortV3();
        }
        if(sortCase.equalsIgnoreCase("i")){
            this.sortAlgorithm = new Intersort();
        }
        print("What kind of element do you want to read in? int/str ");
        String element = readLine();


        String check;
        int indexcnt = 0;

        do{
            dynamic(indexcnt);
            if(element.equals("str")){
                print("Please type your word here: ");
                cArray[indexcnt] = new StringElement(readLine());


            }else if(element.equals("int")){
                print("Please type your Number here: ");
                cArray[indexcnt] = new IntElement(readInt());
                for(Comparable t : cArray)
                    println(((IntElement)t).getKey()+" ");
            }
            println("Do you want to add another items? y/n");
            do {
                check = readLine();
            }while (check.isBlank() || check.isEmpty());
            indexcnt++;
        }while(check.equals("y"));
        println("Array to sort: ");
        printArray(cArray,"n");
        println();
        SortInterface.sortArray(cArray, this.sortAlgorithm);
        print("In which direction should the go? \nn-normal(left to right\nr-reverse(right to left)\nPlease type in here: ");
        String direction = readLine();
        println("Sorted Array: ");
        printArray(cArray,direction);
    }

    private void dynamic(int index){
        if (index >= cArray.length){
            Comparable[] newArray = new Comparable[index+1];
            for (int i = 0; i < cArray.length; i++) {
                newArray[i] = cArray[i];
            }
            cArray = newArray;
        }
    }

    private void printArray(Comparable array[], String direction){
        if(direction.equals("n")) {
            for (Comparable i : array) {
                if (i instanceof IntElement) {
                    print(((IntElement) i).getKey() + " ");
                }
                if (i instanceof StringElement)
                    print(((StringElement) i).getKey() + " ");
            }
        } else if(direction.equals("r")){
            for (int i = array.length-1; i >=0 ; i--) {
                if (array[i] instanceof IntElement) {
                    print(((IntElement) array[i]).getKey() + " ");
                }
                if (array[i] instanceof StringElement)
                    print(((StringElement) array[i]).getKey() + " ");
            }
        }

    }


}

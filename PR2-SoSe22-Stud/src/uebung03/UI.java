package uebung03;
import uebung02.BinaryTree.Element;
import uebung02.BinaryTree.IntElement;

import static gdi.MakeItSimple.*;


public class UI {

    IntElement[] intArray = new IntElement[1];

    public void menu(){

        print("Welches Sortierverfahren wollen Sie verwinden? ");
        String sortCase = readLine();
        print("What kind of element do you want to read in? int/str ");
        String element = readLine();


        String check;
        int indexcnt = 0;
        do{

            if(element.equals("str")){

            }else if(element.equals("int")){
                intArray[indexcnt] = new IntElement(readInt());
            }
            println("Do you want to add another items? y/n");
            check = readLine();

        }while(check.equals("y"));


    }

    public void dynamic(int index){
        if (index >= intArray.length){
            IntElement[] newArray = new IntElement[index+1];
            for (int i = 0; i < intArray.length; i++) {
                newArray[i] = intArray[i];
            }
            intArray = newArray;
        }
    }
}

package uebung02.BinaryTree;
import gdi.MakeItSimple;

import java.util.ArrayList;
import java.util.Map;

import static gdi.MakeItSimple.*;
public class NewUI {

    private ArrayList<BinaryTree> trees;

    public NewUI(){
        this.trees = new ArrayList<>();
    }

    public static void main(String args[]){
        new NewUI().runUI();
    }

    public void runUI(){
        boolean checkdo = true; // create checkdo variable(condition for do while loop)
        println("Welcome on the Tree Menue!");
        do{
            println("[1] create new tree");
            println("[2] list existing trees");
            println("[3] select Tree");

        }while(checkdo);
    }

   private void createNewTree(){

   }
}

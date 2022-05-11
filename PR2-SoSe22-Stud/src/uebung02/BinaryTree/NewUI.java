package uebung02.BinaryTree;
import gdi.MakeItSimple;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static gdi.MakeItSimple.*;
public class NewUI {

    private ArrayList<BinaryTree> trees;
    private Scanner sc;

    public NewUI(){
        this.sc = new Scanner(System.in);
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

            switch (Integer.parseInt(readLine())) { // switch case
                case(1):
                    createNewTree();
                    break;
                case(2):
                    listExistingTrees();
                    break;
                case(3):
                    int index = selectTree();
            }

        }while(checkdo);
    }

   private void createNewTree(){
        this.trees.add(new BinaryTree());
        println("A new Tree was created");
   }

   private void listExistingTrees(){
        if(this.trees.isEmpty())
            println("There are no trees, to create one select \"create new tree\"");
        for(int i = 0; i < this.trees.size(); i++)
           println("[" + i + "]. BinaryTree");

   }

   private int selectTree(){

   }
}

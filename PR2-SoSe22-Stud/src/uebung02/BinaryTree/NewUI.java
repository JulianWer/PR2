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
                    showOptionsForTree(this.trees.get(index));
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
        print("Enter the index of the tree, you want to select: ");
        int i = sc.nextInt();
        if(i < 0 || i >= this.trees.size())
            println("Tree doesnt exists");
        return i;
   }

   private void showOptionsForTree(BinaryTree btree){
       boolean checkdo = true;
       do { // run as long as checkdo is true
           println("You have the following options to use : ");
           println(" [1] insert to tree " +
                   "\n [2] insert from file " +
                   "\n [3] save to file " +
                   "\n [4] contains a node " +
                   "\n [5] get size " +
                   "\n [6] get height " +
                   "\n [7] get the maximal value " +
                   "\n [8] get the minimal value " +
                   "\n [9] remove " +
                   "\n [10] check if empty " +
                   "\n [11] clear the tree " +
                   "\n [12] addAll from otherTree " +
                   "\n [13] print the Inorder " +
                   "\n [14] print the Postorder " +
                   "\n [15] print the Preorder " +
                   "\n [16] print Levelorder " +
                   "\n [17] clone tree " +
                   "\n [18] is equals (structure and elements) " +
                   "\n [19] is equal (content) " +
                   "\n [20] create new tree " +
                   "\n [21] visualize tree " +
                   "\n [22] <= return to main menu");
           print(" Type the Number here: ");

           int selection = sc.nextInt();
           switch(selection){
               case 1: // insert
                   print("insert number: ");
                   boolean newNumbers = true; // create variable newNumbers
                   while (newNumbers) { // loop while newNumbers is true

                           print("Next number: ");
                           int input = Integer.parseInt(readLine()); // parse the input to an integer
                           btree.insert(new IntElement(input)); // call insert method
                           println("Want to enter another element (y/n) ?");
                           String inputstr = readLine(); // check if the user want to type a new number
                           if (!inputstr.equalsIgnoreCase("y"))
                               newNumbers = false;
                   }
                   break;

               case(2):
                       print("Please enter a filepath: ");
                       btree.insertFromFile(readLine());
                       break;

               case(3):
                   println("Type in full file path:");
                   btree.saveToFile(readLine());
                   break;

               case(4):
                   print("Please enter a number which u want to search:");
                   if (btree.contains(new IntElement(Integer.parseInt(readLine())))) {
                       println("contains the number");
                   } else
                       println("contains not the number");
                   break;

               case(5):
                   println("size: " + btree.size());
                   break;
               case(6):
                   println("height: " + btree.height());
                   break;

               case(7):
                   println("The max value is : " + (Integer) btree.getMax().getKey());
                   break;
               case(8):
                   println("The min value is : " + (Integer) btree.getMin().getKey());
                   break;
               case(9):
                   println("Type in Number: ");
                   btree.remove(new IntElement(Integer.parseInt(readLine())));
                   break;
               case(10):
                   if (btree.isEmpty()) {
                       println("Binary tree is Empty");
                   } else {
                       println("Binary tree is not Empty");
                   }
                   break;
               case(11):
                   btree.clear();
                   break;
               case(12):
                   print("enter the index of the tree, you want to add: ");
                   int index = readInt();
                   if(index < 0 || index >= this.trees.size()) {
                       println("tree doesnt exist");
                   }else
                       btree.addAll(this.trees.get(index));
                   break;
               case(13):
                   btree.printInorder();
                   break;
               case(14):
                   btree.printPostorder();
                   break;
               case(15):
                   btree.printPreorder();
                   break;
               case(16):
                   btree.printLevelorder();
                   break;
               case(17):
                   this.trees.add((BinaryTree)btree.clone());
                   println("Tree is cloned. The index of the clone tree is: " + (this.trees.size() - 1));
                   break;
               case(18):
                   print("select the index of another tree to compare with: ");
                   int i = readInt();
                   if(i < 0 || i >= this.trees.size()) {
                       println("tree doesnt exist");
                       break;
                   }
                   boolean b = btree.equals(this.trees.get(i));
                   if(b)
                       println("identical");
                   else
                       println("not identical");
                   break;

               case(19):
                   print("select the index of another tree to compare with: ");
                   i = readInt();
                   if(i < 0 || i >= this.trees.size()) {
                       println("tree doesnt exist");
                       break;
                   }
                   b = btree.equal(this.trees.get(i));
                   if(b)
                       println("identical");
                   else
                       println("not identical");
                   break;
               case 20:
                   this.trees.add((BinaryTree) btree.createTree());
                   println("Tree created. The index of the tree tree is: " + (this.trees.size() - 1));
                   break;
           }

       }while(checkdo);
   }
}

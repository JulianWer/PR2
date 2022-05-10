package uebung02.BinaryTree;

import static gdi.MakeItSimple.*;

import java.util.Scanner;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */
public class UI {

    private BinaryTree btree;
    private BinaryTree btree2;

    public static void main(String[] args) {
        new UI();
    }

    public UI() {
        runUI();
    }

    private void runUI() {
        this.btree = new BinaryTree(); // create Binary tree
        boolean checkdo = true; // create checkdo variable(condition for do while loop)
        println("Welcome on the Tree Menue!");
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
                    "\n [21] visualize tree ");
            print(" Type the Number here: ");
            String line;
            switch (readLine()) { // switch case
                case "1": // insert
                    print("insert number: ");
                    boolean newNumbers = true; // create variable newNumbers
                    while (newNumbers) { // loop while newNumbers is true
                        print("Which tree? (1/2)");
                        line = readLine();
                        if (readLine().equals("1")) {

                            print("Next number: ");
                            int input = Integer.parseInt(readLine()); // parse the input to an integer
                            btree.insert(new IntElement(input)); // call insert method
                            println("Want to enter another element (y/n) ?");
                            String inputstr = readLine(); // check if the user want to type a new number
                            if (!inputstr.equalsIgnoreCase("y"))
                                newNumbers = false;


                        } else if (line.equals("2") && btree2 != null) {

                            print("Next number: ");
                            int input = Integer.parseInt(readLine()); // parse the input to an integer
                            btree2.insert(new IntElement(input)); // call insert method
                            println("Want to enter another element (y/n) ?");
                            String inputstr = readLine(); // check if the user want to type a new number
                            if (!inputstr.equalsIgnoreCase("y"))
                                newNumbers = false;


                        } else
                            println("tree is not initialized please create a new tree");
                    }
                    break;
                case "2":// insert form file
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1")) {
                        print("Please enter a filepath: ");
                        btree.insertFromFile(readLine());
                    } else if (line.equals("2") && btree2 != null) {
                        print("Please enter a filepath: ");
                        btree2.insertFromFile(readLine());
                    } else
                        println("tree is not initialized please create a new tree");

                    break;
                case "3":// contains
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1")) {
                        println("Type in full file path:");
                        btree.saveToFile(readLine());
                    } else if (line.equals("2") && btree2 != null) {
                        println("Type in full file path:");
                        btree2.saveToFile(readLine());
                    } else
                        println("tree is not initialized please create a new tree");
                    break;
                case "4":// get max value
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1")) {
                        print("Please enter a number which u want to search:");
                        if (btree.contains(new IntElement(Integer.parseInt(readLine())))) {
                            println("contains the number");
                        } else
                            println("contains not the number");
                    } else if (line.equals("2") && btree2 != null) {
                        print("Please enter a number which u want to search:");
                        if (btree2.contains(new IntElement(Integer.parseInt(readLine())))) {
                            println("contains the number");
                        } else
                            println("contains not the number");
                    } else
                        println("tree is not initialized please create a new tree");
                    break;


                case "5":// get min value
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1"))
                        println("size: " + btree.size());
                    else if (line.equals("2"))
                        println("size: " + btree2.size());
                    else
                        println("tree is not initialized please create a new tree");
                    break;
                case "6": // check if binary tree is empty
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1"))
                        println("height: " + btree.height());
                    else if (line.equals("2") && btree2 != null)
                        println("height: " + btree2.height());
                    else
                        println("tree is not initialized please create a new tree");
                    break;

                case "7":// clear binary tree
                    print("Which tree? (1/2) ");
                    line = readLine();
                    if (line.equals("1"))
                        println("The max value is : " + (Integer) btree.getMax().getKey());
                    else if (line.equals("2") && btree2 != null)
                        println("The max value is : " + (Integer) btree2.getMax().getKey());
                    else
                        println("tree is not initialized please create a new tree");
                    break;

                case "8":// print inorder
                    print("Which tree? (1/2) ");
                    line = readLine();
                    if (line.equals("1"))
                        println("The min value is : " + (Integer) btree.getMin().getKey());
                    else if (line.equals("2") && btree2 != null)
                        println("The min value is : " + (Integer) btree2.getMin().getKey());
                    else
                        println("tree is not initialized please create a new tree");
                    break;

                case "9":// print postorde
                    print("Which tree? (1/2) ");
                    line = readLine();
                    if (line.equals("1")) {
                        println("Type in Number: ");
                        btree.remove(new IntElement(Integer.parseInt(readLine())));
                    } else if (line.equals("2") && btree2 != null) {
                        println("Type in Number: ");
                        btree2.remove(new IntElement(Integer.parseInt(readLine())));
                    } else
                        println("tree is not initialized please create a new tree");
                    break;
                case "10":// print preorder
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1")) {
                        if (btree.isEmpty()) {
                            println("Binary tree is Empty");
                        } else {
                            println("Binary tree is not Empty");
                        }
                    } else if (line.equals("2") && btree2 != null) {
                        if (btree2.isEmpty()) {
                            println("Binary tree is Empty");
                        } else {
                            println("Binary tree is not Empty");
                        }
                    } else
                        println("tree is not initialized please create a new tree");
                    break;
                case "11":// draw Tree in a window
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1"))
                        btree.clear();
                    else if (line.equals("2") && btree2 != null)
                        btree2.clear();
                    else
                        println("tree is not initialized please create a new tree");
                    break;
                case "12":

                    break;
                case "13":
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1"))
                        btree.printInorder();
                    else if (line.equals("2") && btree2 != null)
                        btree2.printInorder();
                    else
                        println("tree is not initialized please create a new tree");
                    break;
                case "14":
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1"))
                        btree.printPostorder();
                    else if (line.equals("2") && btree2 != null)
                        btree2.printPostorder();
                    else
                        println("tree is not initialized please create a new tree");
                    break;
                case "15":
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1"))
                        btree.printPreorder();
                    else if (line.equals("2") && btree2 != null)
                        btree2.printPreorder();
                    else
                        println("tree is not initialized please create a new tree");
                    break;
                case "16":
                    print("Which tree? (1/2) ");
                    line = readLine();
                    if (line.equals("1"))
                        btree.printLevelorder();
                    else if (line.equals("2") && btree2 != null)
                        btree2.printLevelorder();
                    else
                        println("tree is not initialized please create a new tree");
                    break;
                case "17":
                    btree2 = (BinaryTree) btree.clone();
                    break;
                case "18":
                    btree.equals(btree2);
                    break;
                case "19":
                    btree.equal(btree2);
                    break;
                case "20":
                    btree2 = (BinaryTree) btree.createTree();
                    break;
                case "21":
                    print("Which tree? (1/2)");
                    line = readLine();
                    if (line.equals("1")) {
                        btree.visualize();
                    } else if (line.equals("2") && btree2 != null) {
                        btree2.visualize();
                    } else
                        println("tree is not initialized please create a new tree");

                    break;

            }
            println("Do you want to do something else? y/n");
            String inputstr = readLine();
            // check if the user want to do something else
            if (inputstr.equalsIgnoreCase("y")) checkdo = true;
            else {
                checkdo = false;
                println("goodbye, thanks for using the tool");
                System.exit(0);// exit Program
            }

        } while (checkdo);

    }


}

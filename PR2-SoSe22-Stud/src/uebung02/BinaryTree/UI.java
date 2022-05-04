package uebung02.BinaryTree;
import static gdi.MakeItSimple.*;

import java.util.Scanner;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */
public class UI {
	
	private BinaryTree btree;
	
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
			println(" [1] insert to tree \n [2] insert from file \n [3] contains a node \n [4] get the maximal value \n [5] get the minimal value \n [6] check if empty \n [7] clear the tree \n [8] print the Inorder \n [9] print the Postorder \n [10] print the Preorder \n [11] visualize tree");
			print(" Type the Number here: ");
			switch (readLine()) { // switch case
				case "1": // insert
					print("insert number: ");
					boolean newNumbers = true; // create variable newNumbers

					while (newNumbers) { // loop while newNumbers is true
						print("Next number: ");
						int input = Integer.parseInt(readLine()); // parse the input to an integer
						btree.insert(new IntElement(input)); // call insert method
						println("Weitere Zahlen eingeben (y/n) ?");
						String inputstr = readLine(); // check if the user want to type a new number
						if (!inputstr.equalsIgnoreCase("y"))
							newNumbers = false;

					}
					break;
				case "2":// insert form file
					print("Please enter a filepath: ");
					btree.insertFromFile(readLine());
					break;
				case "3":// contains
					print("Please enter a number which u want to search:");
					int input = Integer.parseInt(readLine());
					if (btree.contains(new IntElement(input))) {
						println("contains the number");
					} else
						println("contains not the number");
					break;
				case "4":// get max value
					println("The max value is : " + btree.getMax());
					break;
				case "5":// get min value
					println("The min value is : " + btree.getMin());
					break;
				case "6": // check if binary tree is empty
					if (btree.isEmpty()) {
						println("Binary tree is Empty");
					} else {
						println("Binary tree is not Empty");
					}
					break;
				case "7":// clear binary tree
					btree.clear();
					println("Tree is cleared");
					break;
				case "8":// print inorder
					btree.printInorder();
					break;
				case "9":// print postorder
					btree.printPostorder();
					break;
				case "10":// print preorder
					btree.printPreorder();
					break;
				case "11":// draw Tree in a window
					btree.visualize();
					break;

			}
			println("Do you want to do something else? y/n");
			String inputstr = readLine();
			// check if the user want to do something else
			if (inputstr.equalsIgnoreCase("y")) checkdo=true;
			else checkdo = false;
		}while(checkdo);
		println("goodbye, thanks for using the tool");
		System.exit(0);// exit Program
	}
	
	
}

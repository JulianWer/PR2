package uebung02.BinaryTree;
import static gdi.MakeItSimple.*;

import java.util.Scanner;

public class UI {
	
	private BinaryTree btree;
	
	public static void main(String[] args) {
		new UI();
	}
	
	public UI() {
		runUI();
	}
	
	private void runUI() {
		this.btree = new BinaryTree();
		println("Welcome on the Tree Menue!");
		println("You have the following options to use : ");
		println(" [1] insert to tree \n [2] insert from file \n [3] contains a node \n [4] get the maximal value \n [5] get the minimal value \n [6] check if empty \n [7] clear the tree \n [8] print the Inorder \n [9] print the Postorder [10] print the Preorder");

		switch (readLine()){
			case "1":
				print("insert number:");
				boolean newNumbers = true;

				while(newNumbers) {
					print("Next number: ");
					int input = Integer.parseInt(readLine());
					btree.insert(new IntElement(input));
					println("Weitere Zahlen eingeben (y/n) ?");
					String inputstr = readLine();
					if(!inputstr.equalsIgnoreCase("y"))
						newNumbers = false;

				}
			case "2":
				print("Please enter a filepath: ");
				btree.insertFromFile(readLine());
			case "3":
				print("Please enter a number which u want to search:");
				int input = Integer.parseInt(readLine());
				if(btree.contains(new IntElement(input))){
					println("contains the number");
				}else
					println("contains not the number");
			case "4":
				println("The max value is : " +btree.getMax());
			case "5":
				println("The min value is : " +btree.getMin());
			case "6":
			case "7":
			case "8":
			case "9":
			case "10":

		}





		this.btree.visualize();
		
	}
	
	
}

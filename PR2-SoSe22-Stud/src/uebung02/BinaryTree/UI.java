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
		Scanner sc = new Scanner(System.in);
		this.btree = new BinaryTree();
		println("Welcome on the Tree Menue!");
		System.out.println("Zahlen eingeben:");
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
		this.btree.visualize();
		
	}
	
	
}

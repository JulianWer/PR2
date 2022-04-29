package uebung02.BinaryTree;

import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.*;
import static pr2.util.Queue.*;
import static pr2.util.LinkedList.*;


import pr2.util.LinkedListI;
import pr2.util.Queue;
import pr2.util.QueueImpl;
import uebung01.UI;

public class BinaryTree implements Tree {

	private TreeNode root;
	private int size = 0;

	// for testing
//	public static void main(String[] args) {
//		BinaryTree b = new BinaryTree();
//		boolean a = b.insert(1);
//		b.insert(20);
//		b.insert(4);
//		b.insert(7);
//		b.insert(11);
//		System.out.println(b.getMax());
//		System.out.println(b.getMin());
//		System.out.println("Preorder: ");
//		b.printPreorder();
//	}

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(Element rootValue) {
		this.root = new TreeNode(rootValue);
	}

	@SuppressWarnings("unchecked")
	public boolean insert(Element val) {
		System.out.println((int) ((Comparable<Integer>) val));
		// TODO Auto-generated method stub
		TreeNode parent = null;
		TreeNode child = root;
		while (child != null) { // at least 1 node in tree
			parent = child;
			if (val.compareTo(child.getElement()) == 0)
				return false; // element already in tree, i is not inserted
			else if ( val.compareTo(child.getElement()) < 0)
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in right tree
		}
		if (parent == null) // empty tree -> insert first node
			root = new TreeNode(val);
		else if (val.compareTo(parent.getElement()) < 0)
			parent.setLeft(new TreeNode(val)); // insert left from parent
		else
			parent.setRight(new TreeNode(val)); // insert right from parent
		return true; // i successfully inserted
	}

//	public boolean insert(int i) {// ((Comparable<Integer>) i)
//		System.out.println(i);
//		TreeNode parent = null;
//		TreeNode child = root;
//		while (child != null) { // at least 1 node in tree
//			parent = child;
//			if (((Comparable<Integer>) i).compareTo(child.getElement()) == 0)
//				return false; // element already in tree, i is not inserted
//			else if (((Comparable<Integer>) i).compareTo(child.getElement()) < 0)
//				child = child.getLeft(); // insert in left tree
//			else
//				child = child.getRight(); // insert in right tree
//		}
//		// parent node found
//		if (parent == null) // empty tree -> insert first node
//			root = new TreeNode(i);
//		else if (((Comparable<Integer>) i).compareTo(parent.getElement()) < 0)
//			parent.setLeft(new TreeNode(i)); // insert left from parent
//		else
//			parent.setRight(new TreeNode(i)); // insert right from parent
//		this.size++;
//		return true; // i successfully inserted
//	}

	public boolean insertFromFile(String filename) {
		// TODO Auto-generated method stub
		if (!isFilePresent(filename)) {
			println("File not found");
			return false;
		}

		Object file = openInputFile(filename); // opens file for the input
		while (!isEndOfInputFile(file)) {
			this.insert(new IntElement (readInt(file))); // read in elements
		}
		return false;
	}

	public boolean saveToFile(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Element val) {
		// TODO Auto-generated method stub
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Element getMax() {
		// TODO Auto-generated method stub
		TreeNode n = this.root;
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return (Element) n.getElement();

	}

	public Element getMin() {
		// TODO Auto-generated method stub
		TreeNode n = this.root;
		while (n.getLeft() != null) {
			n = n.getLeft();
		}
		return (Element) n;
	}

	public boolean remove(Element val) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.root == null)
			return true;
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public Tree addAll(Tree otherTree) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printInorder() {
		this.printInorder(this.root);

	}

	private void printInorder(TreeNode n) {
		if (n != null) {
			System.out.println(n.getLeft());
			System.out.println(n.getElement());
			System.out.println(n.getRight());
		}
	}

	public void printPostorder() {
		printPostorder(this.root);

	}

	private void printPostorder(TreeNode n) {
		if (n != null) {

			printPostorder(n.getLeft()); // go left
			printPostorder(n.getRight());
			println(n.getElement()); // print when the recursion goes back
		}

	}

	public void printPreorder() {
		this.printPreorder(this.root);
	}

	private void printPreorder(TreeNode n) { // recursive
		if (n != null) {// tree not empty
			System.out.println(n.getElement());
			printPreorder(n.getLeft());
			printPreorder(n.getRight());
		}
	}

	public void printLevelorder() {
		this.printLevelorder(this.root);
	}

	private void printLevelorder(TreeNode k) {
		QueueImpl queue = new QueueImpl();
		queue.enter(k);
		while (queue != null ) {
				TreeNode n = (TreeNode) queue.leave();
				println(n.getElement());
				queue.enter(n.getLeft());
				queue.enter(n.getRight());
				
		}
	}

	public Tree clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equal(Tree otherTree) {
		// TODO Auto-generated method stub
		return false;
	}

	public Tree createTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public void visualize() {
		// TODO Auto-generated method stub

	}

}

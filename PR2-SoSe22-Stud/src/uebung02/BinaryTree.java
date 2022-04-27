package uebung02;

import java.util.ArrayList;

import javax.lang.model.element.Element;

import uebung01.UI;

public class BinaryTree implements Tree {
	

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		boolean a = b.insert(1);
		System.out.println(a);
		

	}
	
	private TreeNode root;
	
	public BinaryTree() {
		this.root = null;
	}
	public BinaryTree(int rootValue) {
		this.root = new TreeNode(rootValue);
	}

	@Override
	public boolean insert(Element val) {
		System.out.println((int) ((Comparable<Integer>) val));
		// TODO Auto-generated method stub
		TreeNode parent = null;
		TreeNode child = root;
		while (child != null) { // at least 1 node in tree
			parent = child;
			if (((Comparable<Integer>) val).compareTo(child.getElement()) == 0)
				return false; // element already in tree, i is not inserted
			else if (((Comparable<Integer>) val).compareTo(child.getElement()) < 0)
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in right tree
		}
		if (parent == null) // empty tree -> insert first node
			root = new TreeNode((int) ((Comparable<Integer>) val));
		else if (((Comparable<Integer>) val).compareTo(parent.getElement()) < 0)
			parent.setLeft(new TreeNode((int) ((Comparable<Integer>) val))); // insert left from parent
		else
			parent.setRight(new TreeNode((int) ((Comparable<Integer>) val))); // insert right from parent
		return true; // i successfully inserted
	}
	
	public boolean insert(int i) {//((Comparable<Integer>) i)
		System.out.println(i);
		TreeNode parent = null;
		TreeNode child = root;
		while (child != null) { // at least 1 node in tree
			parent = child;
			if (((Comparable<Integer>) i).compareTo(child.getElement()) == 0)
				return false; // element already in tree, i is not inserted
			else if (((Comparable<Integer>) i).compareTo(child.getElement()) < 0)
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in right tree
		}
		// parent node found
		if (parent == null) // empty tree -> insert first node
			root = new TreeNode (i);
			else if (((Comparable<Integer>) i).compareTo(parent.getElement()) < 0)
				parent.setLeft(new TreeNode(i)); // insert left from parent
			else
				parent.setRight(new TreeNode(i)); // insert right from parent
		return true; // i successfully inserted
	}
	
	
	

	@Override
	public boolean insertFromFile(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveToFile(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Element val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Element getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Element val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tree addAll(Tree otherTree) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printInorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printPostorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printPreorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printLevelorder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tree clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equal(Tree otherTree) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tree createTree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visualize() {
		// TODO Auto-generated method stub
		
	}
	

}

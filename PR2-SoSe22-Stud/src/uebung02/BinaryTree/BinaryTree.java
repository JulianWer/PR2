package uebung02.BinaryTree;

import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.*;
import static pr2.util.Queue.*;

import graphvisualizer.TreeVisualizer;

import static pr2.util.LinkedList.*;


import pr2.util.LinkedListI;
import pr2.util.Queue;
import pr2.util.QueueImpl;
import uebung01.UI;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class BinaryTree implements Tree {

	private TreeNode root;
	private int size = 0;


	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(Element rootValue) {
		this.root = new TreeNode(rootValue);
	}

	/**
	* Insert method adds an Element to the BinaryTree
	*  @return boolean if the adding is accepted
	*/
	@Override
	//true if inserted 
	// false if error occurred
	public boolean insert(Element val) {

		TreeNode parent = null;
		TreeNode child = root;
		
		while (child != null) { // at least 1 node in tree
			parent = child;
			
			//if (val.compareTo(child.getElement()) == 0) causes problems 
			if (val.compareTo(child.getElement()) == 0) {
				return false; }// element already in tree, i is not inserted
			//else if ( val.compareTo(child.getElement()) < 0)
			
			else if (val.compareTo(child.getElement()) > 0)
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in right tree
			
		}
		this.size += 1; // count size
		if (parent == null) // empty tree -> insert first node
			root = new TreeNode(val);
		//else if (val.compareTo(parent.getElement()) < 0)
		else if(val.compareTo(parent.getElement()) > 0)
			parent.setLeft(new TreeNode(val)); // insert left from parent
		else
			parent.setRight(new TreeNode(val)); // insert right from parent
		return true; // i successfully inserted
	}

	// inserts the data from a file to the binary tree
	@Override
	public boolean insertFromFile(String filename) {
		// TODO Auto-generated method stub
		//rueckgabewert bearbeiten
		if (!isFilePresent(filename)) {
			println("File not found");
			return false;
		}
		boolean ckeckMulti = true;
		Object file = openInputFile(filename); // opens file for the input
		while (!isEndOfInputFile(file)) {
			if(!this.insert(new IntElement (readInt(file)))){ckeckMulti = false;}; // read in elements
		}
		closeInputFile(file); // closes the input File
		return ckeckMulti; // returns true if the adding is accepted
	}

	// saves the binary tree data to a file
	@Override
	public boolean saveToFile(String filename) {
		// FIXME
		Object output = openOutputFile(filename);
		while(this.root != null) {
			this.root.print(); // prints all elements
		}
		return false;
	}
	@Override
	public boolean contains(Element val) {
		TreeNode parent = null;
		TreeNode child = root;
		boolean found = false;

		
		while(!found && child != null) {
			println((Integer)((IntElement)val).getKey());
			println(((Integer)((IntElement)child.getElement()).getKey()));
			//search for the element which should be deleted
			if(((Integer)((IntElement)val).getKey()).equals( ((Integer)((IntElement)child.getElement()).getKey())) ){
				//break loop
				found = true;
				continue;
			}
			
			if((Integer)((IntElement)val).getKey() < ((Integer)((IntElement)child.getElement()).getKey())) {
				//go left
				parent = child;
				child = child.getLeft();
				continue;
			}
			if((Integer)((IntElement)val).getKey() > ((Integer)((IntElement)child.getElement()).getKey())) {
				//go Right
				parent = child;
				child = child.getRight();
				continue;
			}
			
		}
		return found;
		
	}
	@Override
	public int size() { // size was counted in the insert method
		return this.size;
	}
	@Override
	public int height() { //returns the height of the tree ( levels+1)
		// checks if not empty
		if(this.isEmpty())
			return 0;
		else {
			TreeNode n = this.root;	//calculate the height recursively
			return height(n);
		}
	}
	
	private int height(TreeNode n) {
		int heightLeft = 0;
	    int heightRight = 0;
	    
	    if(n.getLeft()!=null)
	        heightLeft = height(n.getLeft()); // recursive call
	    if(n.getRight()!=null)
	        heightRight = height(n.getRight());
	    if(heightLeft > heightRight){
	        return heightLeft+1; // levels +1
	    }
	    else{
	        return heightRight+1;
	    }
	}
	@Override
	public Element getMax() { // returns the max Element
		TreeNode n = this.root;
		while (n.getRight() != null) {
			n = n.getRight();	//go right as long as there are remaining elements
		}
		return (Element) n.getElement();

	}
	
	
	private TreeNode getMax(TreeNode k) { // used in remove method
		TreeNode n = k;
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n;

	}
	@Override
	public Element getMin() {// returns min element
		TreeNode n = this.root;
		while (n.getLeft() != null) {
			n = n.getLeft();	//go left as long as there are remaining elements
		}
		return (Element) n.getElement();
	}
	@Override
	public boolean remove(Element val) {
		// TODO Auto-generated method stub
		//first to element has to be found, then all references have to be refreshed
		TreeNode parent = null;
		TreeNode child = root;
		boolean found = false;
		boolean deleteLeftRef = false;
		
		while(!found) {
			println((Integer)((IntElement)val).getKey());
			println(((Integer)((IntElement)child.getElement()).getKey()));
			//search for the element which should be deleted
			if(((Integer)((IntElement)val).getKey()).equals( ((Integer)((IntElement)child.getElement()).getKey())) ){
				//break loop
				found = true;
			}
			
			if((Integer)((IntElement)val).getKey() < ((Integer)((IntElement)child.getElement()).getKey())) {
				//go left
				parent = child;
				child = child.getLeft();
				deleteLeftRef = true;
				continue;
			}
			if((Integer)((IntElement)val).getKey() > ((Integer)((IntElement)child.getElement()).getKey())) {
				//go Right
				parent = child;
				child = child.getRight();
				deleteLeftRef = false;
			}
			
		}
		if(child == this.root) {	//delete root
			if(child.getLeft() == null)
				this.root = child.getRight();	//replace the root with right element
			else if(child.getRight() == null)
				this.root = child.getLeft();	//replace the root with left element
			else {
				//replace the root with biggest element from left tree
				TreeNode k = getMax(child.getLeft());
				int remember = (Integer)((IntElement)k.getElement()).getKey();
				remove(k.getElement());
				((IntElement)this.root.getElement()).setKey(remember);
			
				
				return true;
			}
		}else {
			//delete a normal node
			
			if(child.getLeft() == null) {
				//parent is stored in local object partent
				if(parent.getLeft() == child) {
					parent.setLeft(child.getRight());
				}else {
					parent.setRight(child.getRight());
				}
			}else if(child.getRight() == null) {
				if(parent.getLeft() == child) {
					parent.setLeft(child.getLeft());
				}else {
					parent.setRight(child.getLeft());
				}
			}else {
				TreeNode k = getMax(child.getLeft());
				int remember = (Integer)((IntElement)k.getElement()).getKey();
				remove(k.getElement());
				((IntElement)child.getElement()).setKey(remember);	
			}

		}
	
		return true;
	}
	
	@Override
	public boolean isEmpty() { // returns a boolean, checks if the binary tree is empty
		return (this.root == null);
	}
	
	@Override
	public void clear() {
		this.root = null; // clears entire tree
		this.size = 0; // resets size
	}


	@Override
	public Tree addAll(Tree otherTree) {
		// TODO Auto-generated method stub
		TreeNode child = ((BinaryTree)otherTree).root;
		if(child != null) {
			this.insert(child.getElement());
			addAll(child.getLeft(), this);
			addAll(child.getRight(), this);
		}
		
		
		return this;
	}
	
	private void addAll(TreeNode n, BinaryTree b) {
		if(n != null) {
			b.insert(n.getElement());
			if(n.getLeft() != null)
				addAll(n.getLeft(), b);
			if(n.getRight() != null)
				addAll(n.getRight(), b);
		}
		
	}
	@Override
	public void printInorder() {
		this.printInorder(this.root); // calls private method

	}

	private void printInorder(TreeNode n) {
		if (n != null) {
			printInorder(n.getLeft()); // recursive call
			print(" "+(Integer)((IntElement)n.getElement()).getKey()); // prints out
			printInorder(n.getRight());
		}
	}
	
	@Override
	public void printPostorder() {
		printPostorder(this.root);

	}

	private void printPostorder(TreeNode n) {
		if (n != null) {

			printPostorder(n.getLeft()); // go left
			printPostorder(n.getRight());
			print(" "+(Integer)((IntElement)n.getElement()).getKey()); // print when the recursion goes back
		}

	}
	@Override
	public void printPreorder() {
		this.printPreorder(this.root);// calls method
	}

	private void printPreorder(TreeNode n) { // recursive
		if (n != null) {// tree not empty
			print(" "+(Integer)((IntElement)n.getElement()).getKey());
			printPreorder(n.getLeft());
			printPreorder(n.getRight());
		}
	}

	@Override
	public void printLevelorder() {
		this.printLevelorder(this.root);
	}

	private void printLevelorder(TreeNode k) {
		QueueImpl queue = new QueueImpl();
		queue.enter(k);
		while (queue != null ) {
				TreeNode n = (TreeNode) queue.leave();
				if(n == null)
					return;
				print(" "+(Integer)((IntElement)n.getElement()).getKey());
				queue.enter(n.getLeft());
				queue.enter(n.getRight());
				
		}
	}

	@Override
	public Tree clone() {
		// TODO Auto-generated method stub
		BinaryTree treeClone = new BinaryTree();
		treeClone.root = clone(this.root);
		
		return treeClone;
	}
	
	private TreeNode clone (TreeNode root) {
		// FIXME
		if(root == null) {
			return null;
		}
		
		TreeNode nodeClone = new TreeNode(this.root.getElement());
		nodeClone.right = clone(this.root.getRight());
		nodeClone.right = clone(this.root.getLeft());
		return nodeClone;
	}
	@Override
	public boolean equals(Object other) { // TODO
		return false;
	}
	@Override
	public boolean equal(Tree otherTree) {
		// FIXME
		QueueImpl queueTree1 = new QueueImpl();
		QueueImpl queueTree2 = new QueueImpl();
		queueTree1.enter(this.root);
		queueTree2.enter(((BinaryTree) otherTree).root);
		while (!queueTree1.isEmpty() && !queueTree2.isEmpty()) {
			TreeNode n1 = (TreeNode) queueTree1.leave();
			TreeNode n2 = (TreeNode) queueTree2.leave();

			if (n1 != null && n2 != null) {
				if (n1.getElement() != n2.getElement())
					return false;
			}
			if (n1 != null) {
				queueTree1.enter(n1.getLeft());
				queueTree1.enter(n1.getRight());
				}
				if (n2 != null) {
					queueTree2.enter(n2.getLeft());
					queueTree2.enter(n2.getRight());
				}
			

		}
		if (queueTree1.isEmpty() ^ queueTree2.isEmpty())
			return false;
		return true;
	}
	@Override
	public Tree createTree() {
		return new BinaryTree();
	}
	@Override
	public void visualize() {
		TreeVisualizer t = new TreeVisualizer();
		
		t.draw(root);

	}

}

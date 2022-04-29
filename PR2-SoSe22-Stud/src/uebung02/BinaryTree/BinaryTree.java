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
	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		boolean a = b.insert(new IntElement(10));
		boolean a2 = b.insert(new IntElement(8));
		a2 = b.insert(new IntElement(12));
		b.insert(new IntElement(4));
		b.insert(new IntElement(9));
		b.insert(new IntElement(11));
		b.insert(new IntElement(15));
		//b.remove(new IntElement(4));
		//b.remove(new IntElement(15));
		
//		System.out.println(a);
//		System.out.println(a2);
//		System.out.println(((IntElement) b.getMax()).getKey());
//		System.out.println(((IntElement) b.getMin()).getKey());
//		System.out.println("Preorder: ");
//		b.printPreorder();
//		System.out.println("start remove");
//		b.remove(new IntElement(8));
		b.remove(new IntElement(15));
		System.out.println("Preorder: ");
		b.printPreorder();
		println("contains: " + b.contains(new IntElement(15)));
	}

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(Element rootValue) {
		this.root = new TreeNode(rootValue);
	}

	public boolean insert(Element val) {
		System.out.println(val);
		// TODO Auto-generated method stub
		TreeNode parent = null;
		TreeNode child = root;
		
		while (child != null) { // at least 1 node in tree
			parent = child;
			
			//if (val.compareTo(child.getElement()) == 0) causes problems 
			if(((Integer)((IntElement)val).getKey()) == ((Integer)((IntElement)child.getElement()).getKey())) {
				return false; }// element already in tree, i is not inserted
			//else if ( val.compareTo(child.getElement()) < 0)
			
			else if (((Integer)((IntElement)val).getKey()) < ((Integer)((IntElement)child.getElement()).getKey()))
				child = child.getLeft(); // insert in left tree
			else
				child = child.getRight(); // insert in right tre
			
		}
		this.size += 1; // count size
		if (parent == null) // empty tree -> insert first node
			root = new TreeNode(val);
		//else if (val.compareTo(parent.getElement()) < 0)
		else if(((Integer)((IntElement)val).getKey()) < ((Integer)((IntElement)parent.getElement()).getKey()))
			parent.setLeft(new TreeNode(val)); // insert left from parent
		else
			parent.setRight(new TreeNode(val)); // insert right from parent
		return true; // i successfully inserted
	}

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
		Object output = openOutputFile(filename);
		while(this.root != null) {
			this.root.print(); // prints all elements
		}
		return false;
	}

	public boolean contains(Element val) {
		// TODO Auto-generated method stub
		TreeNode parent = null;
		TreeNode child = root;
		boolean found = false;
		boolean deleteLeftRef = false;
		
		while(!found && child != null) {
			System.out.println((Integer)((IntElement)val).getKey());
			System.out.println(((Integer)((IntElement)child.getElement()).getKey()));
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
			
		}if(found) {
			return true;
		}else
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
	
	
	private TreeNode getMax(TreeNode k) {
		// TODO Auto-generated method stub
		TreeNode n = k;
		while (n.getRight() != null) {
			n = n.getRight();
		}
		return n;

	}

	public Element getMin() {
		// TODO Auto-generated method stub
		TreeNode n = this.root;
		while (n.getLeft() != null) {
			n = n.getLeft();
		}
		return (Element) n.getElement();
	}

	public boolean remove(Element val) {
		// TODO Auto-generated method stub
		//first to element has to be found, then all references have to be refreshed
		TreeNode parent = null;
		TreeNode child = root;
		boolean found = false;
		boolean deleteLeftRef = false;
		
		while(!found) {
			System.out.println((Integer)((IntElement)val).getKey());
			System.out.println(((Integer)((IntElement)child.getElement()).getKey()));
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
			//delete normal node
			
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

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.root == null)
			return true;
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		clear(this.root); // clears entire tree
	}
	
	private void clear(TreeNode node) {
		if(node != null) {
			clear(node.getRight());
			clear(node.getLeft());
			node = null;
		}
	}

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

	public void printInorder() {
		this.printInorder(this.root);

	}

	private void printInorder(TreeNode n) {
		if (n != null) {
			printInorder(n.getLeft());
			println(n.getElement());
			printInorder(n.getRight());
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
			System.out.println((Integer)((IntElement)n.getElement()).getKey());
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
		BinaryTree treeClone = new BinaryTree();
		treeClone.root = clone(this.root);
		
		return treeClone;
	}
	
	private TreeNode clone (TreeNode root) {
		if(root == null) {
			return null;
		}
		
		TreeNode nodeClone = new TreeNode(this.root.getElement());
		nodeClone.right = clone(this.root.getRight());
		nodeClone.right = clone(this.root.getLeft());
		return nodeClone;
	}
	
	public boolean equals(Object other) {
		return false;
	}

	public boolean equal(Tree otherTree) {
		// TODO Auto-generated method stub
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

	public Tree createTree() {
		// TODO Auto-generated method stub
		return new BinaryTree();
	}

	public void visualize() {
		// TODO Auto-generated method stub

	}

}

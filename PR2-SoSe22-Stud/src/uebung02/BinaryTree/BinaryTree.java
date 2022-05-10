package uebung02.BinaryTree;

import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.println;

import static pr2.util.Queue.*;
import static pr.MakeItSimple.*;

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
     *
     * @return true if the adding is accepted
     * @return false if the adding is rejected
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
                return false;
            }// element already in tree, i is not inserted
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
        else if (val.compareTo(parent.getElement()) > 0)
            parent.setLeft(new TreeNode(val)); // insert left from parent
        else
            parent.setRight(new TreeNode(val)); // insert right from parent
        return true; // i successfully inserted
    }

    // inserts the data from a file to the binary tree
    @Override
    public boolean insertFromFile(String filename) {
        boolean insertedElement = false;
        ;
        if (isFilePresent(filename)) {
            int[] elements = readIntegerArray(filename);
            for (int element : elements)
                if (this.insert(new IntElement(element)))
                    insertedElement = true;
        } else
            println(" File not found.");

        return insertedElement; //successful inserted elements from file
    }

    // saves the binary tree data to a file
    @Override
    public boolean saveToFile(String filename) {
        int[] array = new int[this.size()];
        if (saveToFile(this.root, array, 0) == 0)
            return false;
        saveIntegerArray(array, filename);
        return true;
    }

    private int saveToFile(TreeNode root, int[] array, int index) {
        if (root == null) {
            return index;
        }
        array[index++] = (Integer) root.getKey();
        index = saveToFile(root.getLeft(), array, index);
        index = saveToFile(root.getRight(), array, index);
        return index;
    }

    @Override
    public boolean contains(Element val) {
        TreeNode parent = null;
        TreeNode child = root;
        boolean found = false;

        while (!found && child != null) {
            //search for the element which should be deleted
            if (val.compareTo(child.getElement()) == 0) {
                //break loop
                found = true;
                continue;
            }

            if (val.compareTo(child.getElement()) > 0) {
                //go left
                parent = child;
                child = child.getLeft();
                continue;
            }
            if (val.compareTo(child.getElement()) < 0) {
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
        if (this.isEmpty())
            return 0;
        else {
            TreeNode n = this.root;    //calculate the height recursively
            return height(n);
        }
    }

    private int height(TreeNode n) {
        int heightLeft = 0;
        int heightRight = 0;

        if (n.getLeft() != null)
            heightLeft = height(n.getLeft()); // recursive call
        if (n.getRight() != null)
            heightRight = height(n.getRight());
        if (heightLeft > heightRight) {
            return heightLeft + 1; // levels +1
        } else {
            return heightRight + 1;
        }
    }

    @Override
    public Element getMax() { // returns the max Element
        TreeNode n = this.root;
        while (n.getRight() != null) {
            n = n.getRight();    //go right as long as there are remaining elements
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
            n = n.getLeft();    //go left as long as there are remaining elements
        }
        return (Element) n.getElement();
    }

    @Override
    public boolean remove(Element val) {
        //first to element has to be found, then all references have to be refreshed
        TreeNode parent = null;
        TreeNode child = root;
        boolean found = false;

        if (!contains(val)) {
            println("Element does not exist");
            return false;
        }
        while (!found) {
            //search for the element which should be deleted
            if (val.compareTo(child.getElement()) == 0) {
                //break loop
                found = true;
            }

            if (val.compareTo(child.getElement()) > 0) {
                //go left
                parent = child;
                child = child.getLeft();
                continue;
            }
            if (val.compareTo(child.getElement()) < 0) {
                //go Right
                parent = child;
                child = child.getRight();

            }

        }
        if (child == this.root) {    //delete root
            if (child.getLeft() == null)
                this.root = child.getRight();    //replace the root with right element
            else if (child.getRight() == null)
                this.root = child.getLeft();    //replace the root with left element
            else {
                //replace the root with biggest element from left tree
                TreeNode k = getMax(child.getLeft());
                int remember = (Integer) ((IntElement) k.getElement()).getKey();
                remove(k.getElement()); // recursive call
                ((IntElement) this.root.getElement()).setKey(remember); // recursive backwards
            }
        } else {
            //delete a normal node

            if (child.getLeft() == null) {
                //parent is stored in local object partent
                if (parent.getLeft() == child) {
                    parent.setLeft(child.getRight());
                } else {
                    parent.setRight(child.getRight());
                }
            } else if (child.getRight() == null) {
                if (parent.getLeft() == child) {
                    parent.setLeft(child.getLeft());
                } else {
                    parent.setRight(child.getLeft());
                }
            } else {
                TreeNode k = getMax(child.getLeft());
                int remember = (Integer) ((IntElement) k.getElement()).getKey();
                remove(k.getElement());
                ((IntElement) child.getElement()).setKey(remember);
            }

        }
        this.size--;
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
    public Tree addAll(Tree otherTree) { // adds all elements of otherTree to currentTree
        TreeNode child = ((BinaryTree) otherTree).root;
        if (child != null) { // when child is not empty
            this.insert(child.getElement()); // adds element
            addAll(child.getLeft(), this); // calls the private method for left and right
            addAll(child.getRight(), this);
        }
        return this; // returns the Tree
    }

    private void addAll(TreeNode n, BinaryTree b) {
        if (n != null) { // if the TreeNode is not null
            b.insert(n.getElement()); // add an element to the tree (this)
            if (n.getLeft() != null) // when the left side is not null
                addAll(n.getLeft(), b); // recursive call for the left side of each element
            if (n.getRight() != null) // when the right side is not null
                addAll(n.getRight(), b);// recursive call for the right side of each element
        }

    }

    @Override
    public void printInorder() {
        this.printInorder(this.root); // calls private method

    }

    private void printInorder(TreeNode n) {
        if (n != null) {
            printInorder(n.getLeft()); // recursive call
            print(" " + (Integer) ((IntElement) n.getElement()).getKey()); // prints out
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
            print(" " + (Integer) ((IntElement) n.getElement()).getKey()); // print when the recursion goes back
        }

    }

    @Override
    public void printPreorder() {
        this.printPreorder(this.root);// calls method
    }

    private void printPreorder(TreeNode n) { // recursive
        if (n != null) {// tree not empty
            print(" " + (Integer) ((IntElement) n.getElement()).getKey());
            printPreorder(n.getLeft());
            printPreorder(n.getRight());
        }
    }

    @Override
    public void printLevelorder() {
        this.printLevelorder(this.root);
    }

    private void printLevelorder(TreeNode k) {
        QueueImpl queue = new QueueImpl(); // init queue
        queue.enter(k); // adds k to queue
        while (queue != null) { // go in the while when queue is not empty
            TreeNode n = (TreeNode) queue.leave();
            if (n == null) // only when n is null, return
                return;
            print(" " + (Integer) ((IntElement) n.getElement()).getKey()); // print out with recursion
            queue.enter(n.getLeft()); // recursive call in queue to write all elements in queue
            queue.enter(n.getRight());

        }
    }

    @Override
    public Tree clone() {
        BinaryTree treeClone = new BinaryTree();
        treeClone.root = clone(this.root); // calls the private method with clone(this.root)
        return treeClone;
    }

    private TreeNode clone(TreeNode root) {
        if (root == null) { // if root is null then return null
            return null;
        }
        TreeNode nodeClone = new TreeNode(new IntElement((Integer) ((IntElement) root.getElement()).getKey())); // gets each element from root
        //TreeNode nodeClone = new TreeNode(this.root.getElement());
        nodeClone.right = clone(root.getRight()); // recursive call for both sides
        nodeClone.left = clone(root.getLeft());
        return nodeClone; // returns the cloned root
    }

    @Override
    public boolean equals(Object other) { // compares structure and values
        if (!(other instanceof Tree)) // if the Object is no instance of the Tree and the BinaryTree then return false
            return false;
        if (!(other instanceof BinaryTree))
            return false;
        QueueImpl queueTree1 = new QueueImpl();
        QueueImpl queueTree2 = new QueueImpl();
        queueTree1.enter(this.root); // enter root to queue 1
        queueTree2.enter(((BinaryTree) other).root); // enter the root of other to queue 2
        while (!queueTree1.isEmpty() && !queueTree2.isEmpty()) { // loop while the queues are not empty
            TreeNode n1 = (TreeNode) queueTree1.leave(); // write elements from the queue in a new treenode
            TreeNode n2 = (TreeNode) queueTree2.leave();

            if (n1 != null && n2 != null) { // if the treenodes are both not null
                if (((IntElement) n1.getElement()).compareTo(n2.getElement()) != 0) // compare n1 and n2 whether they are not equal, return false
                    return false;
            }
            if (n1 != null) { // go through the elements of n1 and add them to the queue 1
                queueTree1.enter(n1.getLeft()); // get the left and the right node of n1
                queueTree1.enter(n1.getRight());
            }
            if (n2 != null) {
                queueTree2.enter(n2.getLeft());// get the left and the right node of n2
                queueTree2.enter(n2.getRight());
            }
        }
        if (queueTree1.isEmpty() ^ queueTree2.isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean equal(Tree otherTree) { // compares the values
        if (!(otherTree instanceof BinaryTree))
            return false;
        int currentTreeElements[] = this.convertTreeToArray(this); // convert the current tree to an array
        int otherTreeElements[] = ((BinaryTree) otherTree).convertTreeToArray((BinaryTree) otherTree); // convert the otherTree to an array

        if (currentTreeElements.length != otherTreeElements.length) // if both arrays have not the same length return false
            return false;

        //search the equal values in both trees
        for (int i : currentTreeElements) { // for each loop for the first array
            boolean found = false; // set found boolean to false
            for (int i2 : otherTreeElements) { // for each loop for the second array
                if (i == i2) // compare one value of array 1 with all values from array 2
                    found = true; // if one is equal set found to true
            }
            if (!found) // if one value is not in the other array return false
                return false;
        }
        return true; // at the end return true, because all elements are equal

    }

    private int[] convertTreeToArray(Tree t) { // converts a tree to an array
        int[] array = new int[t.size()];
        saveToFile(((BinaryTree) t).root, array, 0); // calls method saveToFile  (private) writes the elements into the array
        return array; // return the array
    }

    @Override
    public Tree createTree() {
        return new BinaryTree(); // creates a new BinaryTree
    }

    @Override
    public void visualize() {
        TreeVisualizer t = new TreeVisualizer(); // visualizes a tree
        t.draw(root); // draw the root to the window

    }

}

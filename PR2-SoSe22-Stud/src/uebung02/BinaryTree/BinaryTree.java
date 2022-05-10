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
                remove(k.getElement());
                ((IntElement) this.root.getElement()).setKey(remember);


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
    public Tree addAll(Tree otherTree) {
        TreeNode child = ((BinaryTree) otherTree).root;
        if (child != null) {
            this.insert(child.getElement());
            addAll(child.getLeft(), this);
            addAll(child.getRight(), this);
        }


        return this;
    }

    private void addAll(TreeNode n, BinaryTree b) {
        if (n != null) {
            b.insert(n.getElement());
            if (n.getLeft() != null)
                addAll(n.getLeft(), b);
            if (n.getRight() != null)
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
        QueueImpl queue = new QueueImpl();
        queue.enter(k);
        while (queue != null) {
            TreeNode n = (TreeNode) queue.leave();
            if (n == null)
                return;
            print(" " + (Integer) ((IntElement) n.getElement()).getKey());
            queue.enter(n.getLeft());
            queue.enter(n.getRight());

        }
    }

    @Override
    public Tree clone() {
        BinaryTree treeClone = new BinaryTree();
        treeClone.root = clone(this.root);

        return treeClone;
    }

    private TreeNode clone(TreeNode root) {
        // FIXME
        if (root == null) {
            return null;
        }

        TreeNode nodeClone = new TreeNode(new IntElement((Integer) ((IntElement) root.getElement()).getKey()));
        //TreeNode nodeClone = new TreeNode(this.root.getElement());
        nodeClone.right = clone(root.getRight());
        nodeClone.left = clone(root.getLeft());
        return nodeClone;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tree))
            return false;
        return this.equal((Tree) other);
    }

    @Override
    public boolean equal(Tree otherTree) {
        if (!(otherTree instanceof BinaryTree))
            return false;
        QueueImpl queueTree1 = new QueueImpl();
        QueueImpl queueTree2 = new QueueImpl();
        queueTree1.enter(this.root);
        queueTree2.enter(((BinaryTree) otherTree).root);
        while (!queueTree1.isEmpty() && !queueTree2.isEmpty()) {
            TreeNode n1 = (TreeNode) queueTree1.leave();
            TreeNode n2 = (TreeNode) queueTree2.leave();

            if (n1 != null && n2 != null) {
                if (((IntElement) n1.getElement()).compareTo(n2.getElement()) != 0)
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

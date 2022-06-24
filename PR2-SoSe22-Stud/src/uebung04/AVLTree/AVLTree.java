package uebung04.AVLTree;

import pr2.util.QueueImpl;
import uebung04.BinaryTree.BinaryTree;
import uebung04.BinaryTree.IntElement;
import uebung04.BinaryTree.Tree;
import uebung04.BinaryTree.TreeNode;

import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;

public class  AVLTree extends BinaryTree {
    public AVLTree(){
        super();
    }

    @Override
    public boolean insert(Comparable elem){
        try {
            this.root = insertR((AVLTreeNode) this.root, new AVLTreeNode(elem));
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private AVLTreeNode insertR(AVLTreeNode node, AVLTreeNode dataToInsert) throws Exception {
        if(node == null)
            return dataToInsert;
        else if(dataToInsert.getElement().compareTo(node.getElement()) < 0)
            node.setLeft(insertR((AVLTreeNode) node.getLeft(), dataToInsert));
        else if(dataToInsert.getElement().compareTo(node.getElement()) > 0)
            node.setRight(insertR((AVLTreeNode) node.getRight(), dataToInsert));
        else if(dataToInsert.getElement().compareTo(node.getElement()) == 0)
            throw new Exception("Element already inserted");
        return checkForRotation(node);
    }

    private AVLTreeNode checkForRotation(AVLTreeNode currentNode){
        //calculate balance
        int balance = currentNode.calculateBalance();

        //left-heavy
        if(balance > 1){
            //do rightrotation
            if(((AVLTreeNode)currentNode.getLeft()).calculateBalance() < 0) // doppelte rotation
                currentNode.setLeft(rotateLeft((AVLTreeNode) currentNode.getLeft()));

            return rotateRight(currentNode);
        }

        //right-heavy
        if(balance < -1){
            if(((AVLTreeNode)currentNode.getRight()).calculateBalance() > 0)
                currentNode.setRight(rotateRight((AVLTreeNode) currentNode.getRight()));
            return rotateLeft(currentNode);
        }

        return currentNode;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode t){
        AVLTreeNode tmp = (AVLTreeNode) t.getRight();
        t.setRight(t.getRight().getLeft());
        tmp.setLeft(t);
        return tmp;
    }

    private AVLTreeNode rotateRight(AVLTreeNode t){
        AVLTreeNode tmp = (AVLTreeNode) t.getLeft();
        t.setLeft(t.getLeft().getRight());
        tmp.setRight(t);
        return tmp;
    }

//    @Override
//    public boolean remove(Comparable elem){
//        if(!this.contains(elem))
//            return false;
//
//        deleteR((AVLTreeNode) this.root, elem);
//        return true;
//    }
//
//    private AVLTreeNode deleteR(AVLTreeNode node, Comparable value){
//        if(node == null)
//            return null;
//        if(value.compareTo(node.getElement()) < 0)
//            node.setLeft(this.deleteR((AVLTreeNode) node.getLeft(), value));     //recursive call on left side
//        else if(value.compareTo(node.getElement()) > 0)
//            node.setRight(this.deleteR((AVLTreeNode) node.getRight(), value));    //recursive call on right
//        else{
//            if(node.getLeft() == null)
//                return (AVLTreeNode) node.getRight();
//            else if(node.getRight() == null)
//                return (AVLTreeNode) node.getLeft();
//
//            //node to be deleted has two children
//            node.setKey(this.getMax(node.getLeft()));
//            node.setLeft(this.deleteR((AVLTreeNode) node.getLeft(),  node.getElement()));
//        }
//
//        return checkForRotation(node);
//    }

    @Override
    public void printPostorder() {
        this.printPostorder(this.root);

    }
    @Override
    public void printInorder() {
        this.printInorder(this.root); // calls private method

    }
    public void printPreorder() {
        this.printPreorder(this.root);// calls method
    }

    private void printPreorder(TreeNode n) { // recursive
        if (n != null) {// tree not empty
            int balance = ((AVLTreeNode)n).calculateBalance();
            print( n.getKey() + "(" + balance + ") "); // prints out
            printPreorder(n.getLeft());
            printPreorder(n.getRight());
        }
    }

    private void printInorder(TreeNode n) {
        if (n != null) {
            printInorder(n.getLeft()); // recursive call
            int balance = ((AVLTreeNode)n).calculateBalance();
            print( n.getKey() + "(" + balance + ") "); // prints out
            printInorder(n.getRight());
        }
    }

    private void printPostorder(TreeNode n){
        if (n != null) {
            printPostorder(n.getLeft()); // go left
            printPostorder(n.getRight());
            int balance = ((AVLTreeNode)n).calculateBalance();
            print( n.getKey() + "(" + balance + ") "); // print when the recursion goes back
        }
    }

    @Override
    public void printLevelorder() {
        this.printLevelorder(this.root);
    }


    private void printLevelorder(TreeNode k) {
        if(k == null)   return;
        QueueImpl queue = new QueueImpl(); // init queue
        queue.enter(k); // adds k to queue
        while (!queue.isEmpty()) { // go in the while when queue is not empty
            TreeNode n = (TreeNode) queue.leave();
            int balance = ((AVLTreeNode)n).calculateBalance();
            print( n.getKey() + "(" + balance + ") "); // print out with recursion
            if(n.getLeft() != null)
                queue.enter(n.getLeft()); // recursive call in queue to write all elements in queue
            if(n.getRight() != null)
                queue.enter(n.getRight());

        }
    }

    @Override // because of insert method is different
    public Tree addAll(Tree otherTree) { // adds all elements of otherTree to currentTree
        TreeNode child = ((AVLTree) otherTree).root;
        if (child != null) { // when child is not empty
            this.insert(child.getElement()); // adds element
            addAll((AVLTreeNode) child.getLeft(), this); // calls the private method for left and right
            addAll((AVLTreeNode) child.getRight(), this);
        }
        return this; // returns the Tree
    }
    private void addAll(AVLTreeNode n, AVLTree b) {
        if (n != null) { // if the TreeNode is not null
            b.insert(n.getElement()); // add an element to the tree (this)
            if (n.getLeft() != null) // when the left side is not null
                addAll((AVLTreeNode)n.getLeft(), b); // recursive call for the left side of each element
            if (n.getRight() != null) // when the right side is not null
                addAll((AVLTreeNode)n.getRight(), b);// recursive call for the right side of each element
        }

    }
}

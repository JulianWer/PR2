package uebung04.AVLTree;

import uebung04.BinaryTree.BinaryTree;
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

    @Override
    public boolean remove(Comparable elem){
        if(!this.contains(elem))
            return false;

        deleteR((AVLTreeNode) this.root, elem);
        return true;
    }

    private AVLTreeNode deleteR(AVLTreeNode node, Comparable value){
        if(node == null)
            return null;
        if(value.compareTo(node.getElement()) < 0)
            node.setLeft(this.deleteR((AVLTreeNode) node.getLeft(), value));     //recursive call on left side
        else if(value.compareTo(node.getElement()) > 0)
            node.setRight(this.deleteR((AVLTreeNode) node.getRight(), value));    //recursive call on right
        else{
            if(node.getLeft() == null)
                return (AVLTreeNode) node.getRight();
            else if(node.getRight() == null)
                return (AVLTreeNode) node.getLeft();

            //node to be deleted has two children
            node.setKey(this.getMax(node.getLeft()));
            node.setLeft(this.deleteR((AVLTreeNode) node.getLeft(),  node.getElement()));
        }

        return checkForRotation(node);
    }

    @Override
    public void printPostorder() {
        this.printPostorder(this.root);

    }

    private void printPostorder(TreeNode n){
        if (n != null) {
            printPostorder(n.getLeft()); // go left
            printPostorder(n.getRight());
            int balance = ((AVLTreeNode)n).calculateBalance();
            print( n.getKey() + "(" + balance + ") "); // print when the recursion goes back
        }
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
        if(balance < 1){
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
}

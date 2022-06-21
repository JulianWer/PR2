package uebung04.AVLTree;

import uebung04.BinaryTree.TreeNode;

import static pr.MakeItSimple.println;

public class Debug {

    public static void main(String args[]){
        AVLTree t = new AVLTree();
        t.insert(10);
        t.insert(7);
        t.insert(5);


        t.printPostorder();




        t.visualize();


    }
}

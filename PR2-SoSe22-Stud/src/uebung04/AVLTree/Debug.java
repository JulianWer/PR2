package uebung04.AVLTree;

import uebung04.BinaryTree.TreeNode;

import static pr.MakeItSimple.println;

public class Debug {

    public static void main(String args[]){
        AVLTree t = new AVLTree();
        t.insert(10);
        t.insert(7);
        t.insert(13);
        t.insert(5);
        t.insert(9);
        t.insert(2);

        t.printPostorder();




        t.visualize();


    }
}

package uebung04;

import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;

public class TreeUI {
    public static void main(String args[]){
        println("Select [0] for Binary-Tree UI or [1] for AVL-TreeNode ");
        int selection = readInt();

        if(selection == 0)
            new uebung04.BinaryTree.UI().runUI();
        else
            new uebung04.AVLTree.UIAVLTree().runUI();

    }
}

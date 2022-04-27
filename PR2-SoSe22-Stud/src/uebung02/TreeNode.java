package uebung02;

public class TreeNode {

	private int elem;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int i) {
		elem = i;
		left = right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public int getElement() {
		return elem;
	}

	public void setLeft(TreeNode n) {
		left = n;
	}

	public void setRight(TreeNode n) {
		right = n;
	}

	public void setElement (int e) {
		elem = e;
	}
	
}
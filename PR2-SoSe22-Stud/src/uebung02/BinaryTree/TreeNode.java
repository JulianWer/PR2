package uebung02.BinaryTree;

public class TreeNode{

	private Element elem;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(Element i) {
		elem = i;
		left = right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public Element getElement() {
		return elem;
	}

	public void setLeft(TreeNode n) {
		left = n;
	}

	public void setRight(TreeNode n) {
		right = n;
	}

	public void setElement (Element e) {
		elem = e;
	}
	
}
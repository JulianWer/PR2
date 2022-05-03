package uebung02.BinaryTree;

public class IntElement implements Element, Cloneable {
	private Integer key;
	
	public IntElement(int i) {
		this.key = i;
	}
	
	public void setKey(int i) {
		this.key = i;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}
	
	@Override
    public Element clone() { // clone method from interface
		// TODO Auto-generated method stub
		return null;	
	}

}

package assignment1;

import assignment1.A1TreeNode;

public interface A1Tree<E> {
	public A1TreeNode<E> root();
	public void addChild(MyTreeNode parent, MyTreeNode child);
	public int size();
	public void printTree();
}

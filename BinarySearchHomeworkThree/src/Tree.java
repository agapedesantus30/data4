/**
 * Class: Tree
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 25, 2018
 * 
 * 
 *          An interface � describes Tree used to contain the attributes of BST.
 * 
 *          Purpose: Methods and the attributes specific to a type of BST.
 *
 */

public interface Tree<E> extends Iterable<E> {
	/** Return true if the element is in the tree */
	public boolean search(E e);

	/**
	 * Insert element o into the binary tree Return true if the element is inserted
	 * successfully
	 */
	public boolean insert(E e);

	/**
	 * Delete the specified element from the tree Return true if the element is
	 * deleted successfully
	 */
	public boolean delete(E e);

	/** Inorder traversal from the root */
	public void inorder();

	/** reverseOrder traversal from the root */
	public void reverseOrder();

	/** Postorder traversal from the root */
	public void postorder();

	/** Preorder traversal from the root */
	public void preorder();

	/** Get the number of nodes in the tree */
	public int getSize();

	/** Return true if the tree is empty */
	public boolean isEmpty();
}

/**
 * Class: AbstractTree
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 25, 2018
 * 
 * 
 *          An interface � describes AbstractTree used to contain the attributes
 *          of BST.
 * 
 *          Purpose: Methods and the attributes specific to a type of BST.
 *
 */

public abstract class AbstractTree<E> implements Tree<E> {
	@Override /** Inorder traversal from the root */
	public void inorder() {
	}

	@Override /** reverseOrder traversal from the root */
	public void reverseOrder() {
	}

	@Override /** Postorder traversal from the root */
	public void postorder() {
	}

	@Override /** Preorder traversal from the root */
	public void preorder() {
	}

	@Override /** Return true if the tree is empty */
	public boolean isEmpty() {
		return getSize() == 0;
	}

}

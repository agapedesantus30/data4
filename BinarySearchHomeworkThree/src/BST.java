/**
 * Class: BST
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 25, 2018
 * 
 * 
 *          This class � describes BST used to contain the method and attributes
 *          for MainForNumberOfOccurance. It also contains the an Anonymous
 *          inner class which directs the actions of textFile
 * 
 *          Purpose: Methods and the attributes specific to a type of BST,
 *
 */

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
	protected TreeNode<E> root;
	protected int size = 0;

	/** Create a default binary tree */
	public BST() {
	}

	/** Create a binary tree from an array of objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	@Override /** Returns true if the element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else // element matches current.element
				return true; // Element is found
		}

		return false;
	}

	private WordCount wordcount;

	private WordCount insert(WordCount node, String text) {
		if (node == null)
			node = new WordCount(text);
		else {
			if (text.compareToIgnoreCase(node.getWord()) > 0)
				node.left = insert(node.left, text);
			else if (text.compareToIgnoreCase(node.getWord()) < 0)
				node.right = insert(node.right, text);
			else {
				int count = node.getCount();
				node.setCount(count + 1);
			}
		}
		return node;
	}

	// wrapper for the ProgramMain class
	public void insertText(String text) {
		wordcount = insert(wordcount, text);
	}

	// print nodes In order traversal
	private void reverseOrder(WordCount r) {
		if (r == null) {
		} else {
			reverseOrder(r.getRight());
			System.out.println(" [Word=" + r.getWord() + ", Count=" + r.getCount() + "]");
			reverseOrder(r.getLeft());
		}
	}

	// public wrapper to call from outside
	public void printTree() {
		reverseOrder(wordcount);
	}

	@Override /** Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	/** Inorder traversal from a subtree */
	protected void inorder(TreeNode<E> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	@Override /** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/** Postorder traversal from a subtree */
	protected void postorder(TreeNode<E> root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	@Override /** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/** Preorder traversal from a subtree */
	protected void preorder(TreeNode<E> root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	/**
	 * This inner class is static, because it does not access any instance members
	 * defined in its outer class
	 */
	public static class TreeNode<E extends Comparable<E>> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array list of nodes
	}

	@Override /**
				 * Delete an element from the binary tree. Return true if the element is deleted
				 * successfully Return false if the element is not in the tree
				 */
	public boolean delete(E e) {
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed at by current
		}

		if (current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element deleted successfully
	}

	@Override /** Obtain an iterator. Use inorder. */
	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
		private int current = 0; // Point to the current element in list

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override /** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		@Override /** Get the current element and move to the next */
		public E next() {
			return list.get(current++);
		}

		@Override /** Remove the current element */
		public void remove() {
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}
	}

	/** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}

	class WordCount implements Comparable<WordCount> {
		WordCount left, right;
		String word;
		int count;

		/**
		 * @return the left
		 */
		public WordCount getLeft() {
			return left;
		}

		/**
		 * @return the right
		 */
		public WordCount getRight() {
			return right;
		}

		/**
		 * @param word
		 *            the word to set
		 */
		public void setWord(String word) {
			this.word = word;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * @param constructor
		 */
		public WordCount() {
			word = "";
			count = 1;
			left = null;
			right = null;
		}

		/**
		 * @param constructor
		 */
		public WordCount(String newWord) {
			word = newWord;
			count = 1;
			left = null;
			right = null;
		}

		/**
		 * @return the word
		 */
		public String getWord() {
			return word;
		}

		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		public void incrmenter() {
			count++;
		}

		@Override
		public int compareTo(WordCount wt) {
			return this.word.compareTo(wt.word);
		}
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		return false;
	}
}
import java.io.*;

public class ReadFileBST {

	public static void main(String[] args) throws IOException {

		String inputFile = "TedAndtheTelephone.txt";

		BST btree = new BST();

		try {

			BufferedReader input = new BufferedReader(new FileReader(inputFile));

			// Scans each word from the input and prints it out
			String data = input.readLine();
			System.out.println("Reading from file");

			int c = 0;

			while (data != null)

			{

				btree.insert(data);

				c++;

				System.out.print(data + " ");

				data = input.readLine();

			}

			System.out.println("\n\nAfter Sorting by using BST in reverse Alphabetical order");

			btree.inorder();

			System.out.println("\n\n" + "No. Words in file:" + c);

			return;

		} catch (FileNotFoundException filenotfoundexception) // Catches file not found exception

		{

			System.out.println("File not found.");

		}

		catch (IOException ioexception)
		// Catches input/output exception

		{

			System.out.println("File input error occured!");

		}

	}

}

// TO BUILD BST

class BST {

	protected BSTNode root = null;

	public BST() {
	}

	public void clear()

	{

		root = null;

	}

	public boolean isEmpty()

	{

		return root == null;

	}

	public void insert(String data) {

		BSTNode current = root;

		BSTNode prev = null;

		while (current != null) { // find a place for inserting new node;

			prev = current;

			if (current.data.compareTo(data) >= 0)

			{

				current = current.right;

			}

			else

			{

				current = current.left;

			}

		}

		if (root == null) // tree is empty;

		{

			root = new BSTNode(data);

		}

		else if (prev.data.compareTo(data) >= 0)

		{

			prev.right = new BSTNode(data);

		}

		else

		{

			prev.left = new BSTNode(data);

		}

	}

	private void inorder(BSTNode current)

	{

		if (current != null)

		{

			inorder(current.left);

			System.out.print(current.data + " ");

			inorder(current.right);

		}

	}

	public void inorder()

	{

		inorder(root);

	}

}

// STURUCTURE FOR BSTNODE

class BSTNode {

	protected String data;

	protected BSTNode left, right;

	public BSTNode()

	{

		left = null;

		right = null;

	}

	public BSTNode(String data)

	{

		this(data, null, null);

	}

	public BSTNode(String data, BSTNode lt, BSTNode rt)

	{

		this.data = data;

		left = lt;

		right = rt;

	}

}


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProgramMain {

	private static BinarySearchTree bst;

	public static void main(String[] args) {
		bst = new BinarySearchTree();
		// Load the tree from the file
		loadFileIntoTree("TedAndtheTelephone.txt");
		// Print the tree in order
		bst.printTree();
	}

	public static void loadFileIntoTree(String fileName) {
		String line = null;
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			// FileReader reads text files.
			fileReader = new FileReader(fileName);
			// wrapping FileReader in BufferedReader for performance.
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				bst.insertText(line);
			}
			// close file.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
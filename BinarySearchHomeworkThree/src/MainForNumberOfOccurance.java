import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class: MainForNumberOfOccurance
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150 Spring 2018 Written: March 25, 2018
 * 
 *          This class � describes MainForNumberOfOccurance used to contain the
 *          textFile. It also contains the main method which starts the program.
 * 
 *          Purpose: Methods and the attributes specific to a type of BST, and
 *          main method needed to run the program.
 *
 */

public class MainForNumberOfOccurance {

	private static BST bst;

	public static void main(String[] args) {
		bst = new BST();
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Class: JavaFxBinaryFileGUI
 * 
 * @author Agapitus Iboro
 * @version 2.0 Course : ITEC 3150 Spring 2018 Written: February 14, 2018
 * 
 * 
 *          This class � describes JavaFxBinaryFileGUI used to contain the start 
 *          method and attributes. It also contains the main method which starts
 *          the program.
 * 
 *          Purpose: Methods and the attributes specific to a type of media device, 
 *          a start method, and main method needed to run the program
 *
 */
public class JavaFxBinaryFileGUI extends Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6908620108955678616L;
	Stage window;
	Scene scene1, sceneA2, sceneB2, sceneC2, sceneD2, sceneE2, sceneF2, sceneG2,
			sceneH2, sceneI2, sceneJ2;
	private String category, name, artist, director, genre, author, platform;
	private int itemNumber;
	private long iSBN;

	/**
	 * @return concatenation of objects
	 */
	@Override
	public String toString() {
		return "[category=" + category + ", name=" + name + ", itemNumber=" + itemNumber + ", artist=" + artist
				+ ", director=" + director + ", genre=" + genre + ", author=" + author + ", iSBN=" + iSBN
				+ ", platform=" + platform + "]";
	}

	/**
	 * Default constructor used to create empty attributes
	 */
	public JavaFxBinaryFileGUI() {
		category = "";
		name = "";
		artist = "";
		director = "";
		genre = "";
		author = "";
		platform = "";
		iSBN = 0;
		itemNumber = 0;
	}

	/**
	 * @param category
	 * @param name
	 * @param artist
	 * @param director
	 * @param genre,
	 * @param author,
	 * @param platform;
	 * @param iSBN;
	 * @param itemNumber;
	 */
	public JavaFxBinaryFileGUI(String category, String name, int itemNumber, String artist, String director,
			String genre, String author, long iSBN, String platform) {
		this.category = category;
		this.name = name;
		this.itemNumber = itemNumber;
		this.artist = artist;
		this.director = director;
		this.genre = genre;
		this.author = author;
		this.iSBN = iSBN;
		this.platform = platform;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist
	 *            the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemNumber() {
		return itemNumber;
	}

	/**
	 * @param itemNumber
	 *            the itemNumber to set
	 */
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the iSBN
	 */
	public long getiSBN() {
		return iSBN;
	}

	/**
	 * @param iSBN
	 *            the iSBN to set
	 */
	public void setiSBN(long iSBN) {
		this.iSBN = iSBN;
	}

	@Override  // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception {
		// creates people.dat binary file by reading in objects
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("people.dat"));

		JavaFxBinaryFileGUI bf1 = new JavaFxBinaryFileGUI("Books", "American Elf 1999 ", 1, "", "", "", "James Kochalka ", 9781603092395L,
				"ebooks");
		JavaFxBinaryFileGUI bf2 = new JavaFxBinaryFileGUI("Music", "That's what i like ", 2, "Bruno Mars ", "", "", "", 0L, "CD");
		JavaFxBinaryFileGUI bf3 = new JavaFxBinaryFileGUI("Books", "Dear Julia ", 3, "", "", "", "Brian Biggs", 9781891830129L,
				"audio books");
		JavaFxBinaryFileGUI bf4 = new JavaFxBinaryFileGUI("Video", "Jumaji Welcome to the Jungle ", 4, "", "Jake Kasdan ", "Comedy ", "",
				0L, "Amazon Video");
		JavaFxBinaryFileGUI bf5 = new JavaFxBinaryFileGUI("Music", "Glorious ", 5, "Macklemore feat Skylar grey ", "", "", "", 0L,
				"Vinyl");
		JavaFxBinaryFileGUI bf6 = new JavaFxBinaryFileGUI("Books", "Lost Girls ", 6, "", "", "", "Alan Moore and Melinda Gebbie ",
				9781603090495L, "Hardcover");
		JavaFxBinaryFileGUI bf7 = new JavaFxBinaryFileGUI("Music", "Come Hang out ", 7, "AJR ", "", "", "", 0L, "Pandora");
		JavaFxBinaryFileGUI bf8 = new JavaFxBinaryFileGUI("Video", "Avengers: age of ultron ", 8, "", "Josh Whedon ", "Action ", "", 0L,
				"DVD");
		JavaFxBinaryFileGUI bf9 = new JavaFxBinaryFileGUI("Video", "Bright ", 9, "", "David Ayer ", "Action ", "", 0L, "Netflix");
		JavaFxBinaryFileGUI bf10 = new JavaFxBinaryFileGUI("Music", "Home ", 10, "MGK ", "", "", "", 0L, "CD");

		objectOutputStream.writeObject(bf1);
		objectOutputStream.writeObject(bf2);
		objectOutputStream.writeObject(bf3);
		objectOutputStream.writeObject(bf4);
		objectOutputStream.writeObject(bf5);
		objectOutputStream.writeObject(bf6);
		objectOutputStream.writeObject(bf7);
		objectOutputStream.writeObject(bf8);
		objectOutputStream.writeObject(bf9);
		objectOutputStream.writeObject(bf10);
		objectOutputStream.close();

		// displays people.dat file onto javaFx GUI
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("people.dat"));

		JavaFxBinaryFileGUI bfReader1 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader2 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader3 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader4 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader5 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader6 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader7 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader8 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader9 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		JavaFxBinaryFileGUI bfReader10 = (JavaFxBinaryFileGUI) objectInputStream.readObject();
		objectInputStream.close();
		
		// read data from binary file
		window = primaryStage;
		Label label = new Label("LIBRARY ITEMS");
		Button buttonA1 = new Button("Category:" + bfReader1.category + " Name:" + bfReader1.name + "  ItemNumber:"
				+ bfReader1.itemNumber + "  Author:" + bfReader1.author + "  ISBN:" + bfReader1.iSBN + "  Platform:"
				+ bfReader1.platform);
		buttonA1.setOnAction(e -> window.setScene(sceneA2));
		Button buttonB1 = new Button("Category:" + bfReader2.category + " Name:" + bfReader2.name + "  ItemNumber:"
				+ bfReader2.itemNumber + "  Artist:" + bfReader2.artist + "  Platform:" + bfReader2.platform);
		buttonB1.setOnAction(e -> window.setScene(sceneB2));
		Button buttonC1 = new Button("Category:" + bfReader3.category + " Name:" + bfReader3.name + "  ItemNumber:"
				+ bfReader3.itemNumber + "  Author:" + bfReader3.author + "  ISBN:" + bfReader3.iSBN + "  Platform:"
				+ bfReader3.platform);
		buttonC1.setOnAction(e -> window.setScene(sceneC2));
		Button buttonD1 = new Button("Category:" + bfReader4.category + " Name:" + bfReader4.name + "  ItemNumber:"
				+ bfReader4.itemNumber + "  Director:" + bfReader4.director + "  Genre:" + bfReader4.genre
				+ "  Platform:" + bfReader4.platform);
		buttonD1.setOnAction(e -> window.setScene(sceneD2));
		Button buttonE1 = new Button("Category:" + bfReader5.category + " Name:" + bfReader5.name + "  ItemNumber:"
				+ bfReader5.itemNumber + "  Artist:" + bfReader5.artist + "  Platform:" + bfReader5.platform);
		buttonE1.setOnAction(e -> window.setScene(sceneE2));
		Button buttonF1 = new Button("Category:" + bfReader6.category + " Name:" + bfReader6.name + "  ItemNumber:"
				+ bfReader6.itemNumber + "  Author:" + bfReader6.author + "  ISBN:" + bfReader6.iSBN + "  Platform:"
				+ bfReader6.platform);
		buttonF1.setOnAction(e -> window.setScene(sceneF2));
		Button buttonG1 = new Button("Category:" + bfReader7.category + " Name:" + bfReader7.name + "  ItemNumber:"
				+ bfReader7.itemNumber + "  Artist:" + bfReader7.artist + "  Platform:" + bfReader7.platform);
		buttonG1.setOnAction(e -> window.setScene(sceneG2));
		Button buttonH1 = new Button("Category:" + bfReader8.category + " Name:" + bfReader8.name + "  ItemNumber:"
				+ bfReader8.itemNumber + "  Director:" + bfReader8.director + "  Genre:" + bfReader8.genre
				+ "  Platform:" + bfReader8.platform);
		buttonH1.setOnAction(e -> window.setScene(sceneH2));
		Button buttonI1 = new Button("Category:" + bfReader9.category + " Name:" + bfReader9.name + "  ItemNumber:"
				+ bfReader9.itemNumber + "  Director:" + bfReader9.director + "  Genre:" + bfReader9.genre
				+ "  Platform:" + bfReader9.platform);
		buttonI1.setOnAction(e -> window.setScene(sceneI2));
		Button buttonJ1 = new Button("Category:" + bfReader10.category + " Name:" + bfReader10.name + "  ItemNumber:"
				+ bfReader10.itemNumber + "  Artist:" + bfReader10.artist + "  Platform:" + bfReader10.platform);
		buttonJ1.setOnAction(e -> window.setScene(sceneJ2));

		// create a scene and places it in the stage(window)
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(label, buttonA1, buttonB1, buttonC1, buttonD1, buttonE1, buttonF1, buttonG1, 
				buttonH1, buttonI1, buttonJ1);
		scene1 = new Scene(layout1, 800, 400);

		// read data from binary file
		Label label1 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonA2 = new Button("Category:" + bfReader1.category + " \nName:" + bfReader1.name + "  \nItemNumber:"
				+ bfReader1.itemNumber + "  \nAuthor:" + bfReader1.author + "  \nISBN:" + bfReader1.iSBN + "  \nPlatform:"
				+ bfReader1.platform);
		buttonA2.setOnAction(e -> window.setScene(scene1));
		Label label2 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonB2 = new Button("Category:" + bfReader2.category + " \nName:" + bfReader2.name + "  \nItemNumber:"
				+ bfReader2.itemNumber + "  \nArtist:" + bfReader2.artist + "  \nPlatform:" + bfReader2.platform);
		buttonB2.setOnAction(e -> window.setScene(scene1));
		Label label3 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonC2 = new Button("Category:" + bfReader3.category + " \nName:" + bfReader3.name + "  \nItemNumber:"
				+ bfReader3.itemNumber + "  \nAuthor:" + bfReader3.author + "  \nISBN:" + bfReader3.iSBN + "  \nPlatform:"
				+ bfReader3.platform);
		buttonC2.setOnAction(e -> window.setScene(scene1));
		Label label4 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonD2 = new Button("Category:" + bfReader4.category + " \nName:" + bfReader4.name + "  \nItemNumber:"
				+ bfReader4.itemNumber + "  \nDirector:" + bfReader4.director + "  \nGenre:" + bfReader4.genre
				+ "  \nPlatform:" + bfReader4.platform);
		buttonD2.setOnAction(e -> window.setScene(scene1));
		Label label5 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonE2 = new Button("Category:" + bfReader5.category + " \nName:" + bfReader5.name + "  \nItemNumber:"
				+ bfReader5.itemNumber + "  \nArtist:" + bfReader5.artist + "  \nPlatform:" + bfReader5.platform);
		buttonE2.setOnAction(e -> window.setScene(scene1));
		Label label6 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonF2 = new Button("Category:" + bfReader6.category + " \nName:" + bfReader6.name + "  \nItemNumber:"
				+ bfReader6.itemNumber + "  \nAuthor:" + bfReader6.author + "  \nISBN:" + bfReader6.iSBN + "  \nPlatform:"
				+ bfReader6.platform);
		buttonF2.setOnAction(e -> window.setScene(scene1));
		Label label7 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonG2 = new Button("Category:" + bfReader7.category + " \nName:" + bfReader7.name + "  \nItemNumber:"
				+ bfReader7.itemNumber + "  \nArtist:" + bfReader7.artist + "  \nPlatform:" + bfReader7.platform);
		buttonG2.setOnAction(e -> window.setScene(scene1));
		Label label8 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonH2 = new Button("Category:" + bfReader8.category + " \nName:" + bfReader8.name + "  \nItemNumber:"
				+ bfReader8.itemNumber + "  \nDirector:" + bfReader8.director + "  \nGenre:" + bfReader8.genre
				+ "  \nPlatform:" + bfReader8.platform);
		buttonH2.setOnAction(e -> window.setScene(scene1));
		Label label9 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonI2 = new Button("Category:" + bfReader9.category + " \nName:" + bfReader9.name + "  \nItemNumber:"
				+ bfReader9.itemNumber + "  \nDirector:" + bfReader9.director + "  \nGenre:" + bfReader9.genre
				+ "  \nPlatform:" + bfReader9.platform);
		buttonI2.setOnAction(e -> window.setScene(scene1));
		Label label10 = new Label("CLICK AGAIN TO RETURN TO LIST");
		Button buttonJ2 = new Button("Category:" + bfReader10.category + " \nName:" + bfReader10.name + "  \nItemNumber:"
				+ bfReader10.itemNumber + "  \nArtist:" + bfReader10.artist + "  \nPlatform:" + bfReader10.platform);
		buttonJ2.setOnAction(e -> window.setScene(scene1));

		// creates scenes and place them in the stage
		VBox layoutA2 = new VBox(10);
		layoutA2.getChildren().addAll(label1, buttonA2);
		sceneA2 = new Scene(layoutA2, 300, 200);
		VBox layoutB2 = new VBox(10);
		layoutB2.getChildren().addAll(label2, buttonB2);
		sceneB2 = new Scene(layoutB2, 300, 200);
		VBox layoutC2 = new VBox(10);
		layoutC2.getChildren().addAll(label3, buttonC2);
		sceneC2 = new Scene(layoutC2, 300, 200);
		VBox layoutD2 = new VBox(10);
		layoutD2.getChildren().addAll(label4, buttonD2);
		sceneD2 = new Scene(layoutD2, 300, 200);
		VBox layoutE2 = new VBox(10);
		layoutE2.getChildren().addAll(label5, buttonE2);
		sceneE2 = new Scene(layoutE2, 300, 200);
		VBox layoutF2 = new VBox(10);
		layoutF2.getChildren().addAll(label6, buttonF2);
		sceneF2 = new Scene(layoutF2, 300, 200);
		VBox layoutG2 = new VBox(10);
		layoutG2.getChildren().addAll(label7, buttonG2);
		sceneG2 = new Scene(layoutG2, 300, 200);
		VBox layoutH2 = new VBox(10);
		layoutH2.getChildren().addAll(label8, buttonH2);
		sceneH2 = new Scene(layoutH2, 300, 200);
		VBox layoutI2 = new VBox(10);
		layoutI2.getChildren().addAll(label9, buttonI2);
		sceneI2 = new Scene(layoutI2, 300, 200);
		VBox layoutJ2 = new VBox(10);
		layoutJ2.getChildren().addAll(label10, buttonJ2);
		sceneJ2 = new Scene(layoutJ2, 300, 200);

		window.setScene(scene1); // Place the scene in the stage
		window.setTitle("Media Library"); // Set the stage title
		window.show(); // Display the stage
	}

	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		launch(args);
	}
}
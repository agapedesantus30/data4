/**
 * Class: HashMapTester
 * 
 * @author Agapitus Iboro
 * @version 1.0 Course : ITEC 3150, Spring, 2018 Written: March 2, 2018
 * 
 * 
 *          This class � This class describes the common attributes and methods
 *          of the HashMapTester being delivered into a library
 * 
 *          Purpose: � This class contains the main method used in running the program and the objects
 *          being added and removed.
 *
 */

public class HashMapTester {

	public static void main(String[] args) {
		MediaHM mediaHm1 = new MediaHM("1", "That's what i like", "CD");
		MediaHM mediaHm2 = new MediaHM("2", "Dear Julia", "Audio Book");
		MediaHM mediaHm3 = new MediaHM("3", "Come Hang Out", "Music");

		MediaHashMap mediaHashMap = new MediaHashMap();
		System.out.println("Contents of HashMap One being added...");
		mediaHashMap.put("media1", mediaHm1);
		System.out.println("Contents of HashMap two being added...");
		mediaHashMap.put("media2", mediaHm2);
		System.out.println("Contents of HashMap three being added...");
		mediaHashMap.put("media3", mediaHm3);

		System.out.println("Three Media Objects added ... \n");
        System.out.println("MediaHashMap... \n" + mediaHashMap);

        System.out.println("\n" + "Removing the first media object ");
        mediaHashMap.remove("media1");
        System.out.println("MediaHashMap... \n" + mediaHashMap);
	}

}

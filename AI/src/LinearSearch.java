
public class LinearSearch {
	
	// solution for problem 19.4 Liang
	// see page 266 in the text for the non-generic solution
	
	public static void main(String[] args) {
		
		int[] list1 = {1, 3, 6, 20, 24, 81, 100000, 2000000};
		System.out.println("Expect 0 : " + linearSearchOld(list1, 1));
		System.out.println("Expect 7 : " + linearSearchOld(list1, 2000000));
		System.out.println("Expect -1 : " + linearSearchOld(list1, 25));
		
		Integer[] list2 = {1, 3, 6, 20, 24, 81, 100000, 2000000};
		System.out.println("Expect 0 : " + linearSearch(list2, 1));
		System.out.println("Expect 7 : " + linearSearch(list2, 2000000));
		System.out.println("Expect -1 : " + linearSearch(list2, 25));
		
		String[] list3 = {"January","February","March","April","May","June",
				"July","August","September","October","November","December"};
		System.out.println("Expect 0 : " + linearSearch(list3, "January"));
		System.out.println("Expect 11 : " + linearSearch(list3, "December"));
		System.out.println("Expect -1 : " + linearSearch(list3, "Sunday"));
	}
	
	public static int linearSearchOld(int[] list, int key) {
		for (int i =0; i < list.length; i++) {
			if (key == list[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for (int i =0; i < list.length; i++)
			if (key.equals(list[i])) return i;
		return -1;
	}
}

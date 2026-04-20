import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class RemoveDuplicates {

	public static <E> ArrayList<E> removeDups(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<E>();
		for (E item : list)
			if (!newList.contains(item))
				newList.add(item);
		return newList;
	}

	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("apple");
		test.add("diamond");
		test.add("cherry");
		test.add("apple");
		System.out.println("list before =" + test);

		ArrayList<String> result = removeDups(test);
		Collections.sort(result);
		System.out.println("list after =" + result);
		
		ArrayList<GregorianCalendar> dates = new ArrayList<>();
		GregorianCalendar gc1 = new GregorianCalendar(2017, 9, 31);
		dates.add(gc1);
		dates.add(new GregorianCalendar(2017, 9, 30));
		dates.add(new GregorianCalendar(2017, 9, 31));
		dates.add(new GregorianCalendar(2016, 9, 30));
		dates.add(new GregorianCalendar(2016, 9, 30));
		dates.add(new GregorianCalendar(2017, 0, 20));
		dates.add(new GregorianCalendar(1776, 6, 4));
		dates.add(new GregorianCalendar(1999, 11, 25));
		
		System.out.print("list before =");
        for (GregorianCalendar day : dates) 
	        System.out.print(format(day) + " ");
        System.out.println();
        
		ArrayList<GregorianCalendar> resultGregorian = removeDups(dates);
		Collections.sort(resultGregorian);
		
		System.out.print("list after =");
        for (GregorianCalendar day : resultGregorian) 
	        System.out.print(format(day) + " ");
        System.out.println();
 		
	}
	
	// taken from
	// https://stackoverflow.com/questions/10829942/using-gregoriancalendar-with-simpledateformat
	public static String format(GregorianCalendar calendar){
	    SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());
	    return dateFormatted;
	}
	
}// end class


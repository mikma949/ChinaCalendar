package calendar;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] date;
		MyCalendar c = new MyCalendar();
		date = c.getDate();
		// date = c.getNextDate();

		Weekday w = new Weekday(c);

		System.out.print(w.getWeekday() + "-");
		for (int j = 0; j < date.length; j++) {

			System.out.print(Integer.toString(date[j]) + "-");
		}
		System.out.println();
		// Compare with Java
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };
		Calendar calendar = Calendar.getInstance();
		calendar.set(c.getYear(), c.getMonth() - 1, c.getDay());
		int i = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		System.out.println("Java day: " + days[i]);
	}

}

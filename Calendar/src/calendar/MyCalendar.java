package calendar;

public class MyCalendar {

	private int year, month, day;
	private MyValidate val;

	public MyCalendar(int inYear, int inMonth, int inDay) {
		year = inYear;
		month = inMonth;
		day = inDay;

	}

	// Returns {0,0,0} if invalid date.
	public int[] getNextDate(MyValidate val) {
		if (val.checkDay(day + 1)) {
			day++;
		} else if (val.checkMonth(month + 1)) {
			day = 1;
			month++;
		} else if (val.checkYear(year + 1)) {
			day = 1;
			month = 1;
			year++;
		} else {
			day = month = year = 0;
		}
		int[] nextDate = { this.year, this.month, this.day };
		return nextDate;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int[] getDate() {
		int[] date = { year, month, day };
		return date;
	}
}

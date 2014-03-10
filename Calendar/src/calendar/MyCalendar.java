package calendar;

public class MyCalendar {

	private int year, month, day;
	private MyValidate val;

	public MyCalendar() {
		val = new MyValidate();
	}


	// Returns {0,0,0} if invalid date.
	public int[] getNextDate() {
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

	public boolean setYear(int year) {
		if (val.checkYear(year)) {
			this.year = year;
			System.out.println("MyCal:setYear: " + this.year);
			return true;
		}
		return false;
	}

	public boolean setMonth(int month) {
		if (val.checkMonth(month)) {
			this.month = month;
			return true;
		}
		return false;
	}

	public boolean setDay(int day) {
		if (val.checkDay(day)) {
			this.day = day;
			return true;
		}
		return false;
	}
	public boolean validate(){
		return (val.checkYear(year) && val.checkMonth(month) && val.checkDay(day));
	}
	public int getDaysInMonth(){
		return val.getDaysInMonth();
	}

	public int getMaxYear() {
		// TODO Auto-generated method stub
		return val.getMaxYear();
	}

	public int getMinYear() {
		// TODO Auto-generated method stub
		return val.getMinYear();
	}
}

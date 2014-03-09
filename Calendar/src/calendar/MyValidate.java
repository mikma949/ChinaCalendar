package calendar;

public class MyValidate {
	private int year, month, day, daysInMonth;
	private int minYear = 1900, maxYear = 2150 ,startYear=1600; 

	public boolean validate() {
		return (checkYear(year) && checkMonth(month) && checkDay(day));
	}

	public boolean checkDay(int day) {
		// TODO Auto-generated method stub

		switch (month) {
		case 2:
			if (!isLeapYear(year))
				setDaysInMonth(28);
			if (isLeapYear(year))
				setDaysInMonth(29);

			if (!isLeapYear(year) && (day < 1 || day > 28)) {
				invalidDay();
				return false;
			}
			if (isLeapYear(year) && (day < 1 || day > 29)) {
				invalidDay();
				return false;
			}

			break;
		case 4:
		case 6:
		case 9:
		case 11:
			setDaysInMonth(31);
			if (day < 1 || day > 30) {
				invalidDay();
				return false;
			}

			break;
		default:
			setDaysInMonth(31);
			if (day < 1 || day > 31) {
				invalidDay();
				return false;
			}

			break;
		}

		this.day = day;
		return true;
	}

	private void setDaysInMonth(int daysInMonth) {
		// TODO Auto-generated method stub
		this.daysInMonth = daysInMonth;
	}

	public boolean checkMonth(int month) {
		// TODO Auto-generated method stub
		if (month < 1 || month > 12) {
			// System.out.println("Invalid month!");
			return false;
		}

		this.month = month;
		return true;
	}

	public boolean checkYear(int year) {
		// TODO Auto-generated method stub
		if (year >= minYear && year <= maxYear) {
			this.year = year;

			return true;
		}
		// System.out.println("Invalid year!");
		return false;
	}

	public boolean isLeapYear(int year) {
		boolean leaped = false;
		if (year % 4 == 0) {
			leaped = true;
			if (year > 1582) {
				if (year % 100 == 0 && year % 400 != 0) {
					leaped = false;
				}
			}
		}
		return leaped;
	}

	private void invalidDay() {
		// TODO Auto-generated method stub
		// System.out.println("Invalid day!");
	}

	public int getDaysInMonth() {
		return daysInMonth;
	}

	public int getYear() {
		return year;
	}

	public MyValidate() {

	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getMinYear() {
		return minYear;
	}

	public int getMaxYear() {
		return maxYear;
	}

	public int getStartYear() {
		return startYear;
	}


}
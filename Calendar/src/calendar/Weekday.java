package calendar;

public class Weekday {

	private MyCalendar c;
	String[] days = { "Friday", "Saturday", "Sunday", "Monday", "Tuesday",
			"Wednesday", "Thursday" };

	public Weekday(MyCalendar c) {
		this.c = c;
	}

	private int numberOfLeapyears() {
		int leapYears = 0;
		for (int i = c.getMinYear(); i < c.getYear(); i++) {
			if (isLeapYear(i))
				leapYears++;
		}
	
		return leapYears;
	}

	private boolean isLeapYear(int year) {
		// TODO Auto-generated method stub
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

	private int numberOfDaysCurrentYear() {
		int days = c.getDay();
		int month = c.getMonth();
		switch (month) {
		default:
			if (month == 1)
				break;

			days += 31;
			if (month == 2)
				break;

			if (c.isLeapYear()) {
				days += 29;
			} else
				days += 28;
			if (month == 3)
				break;

			days += 31;
			if (month == 4)
				break;

			days += 30;
			if (month == 5)
				break;

			days += 31;
			if (month == 6)
				break;

			days += 30;
			if (month == 7)
				break;

			days += 31;
			if (month == 8)
				break;

			days += 31;
			if (month == 9)
				break;

			days += 30;
			if (month == 10)
				break;

			days += 31;
			if (month == 11)
				break;

			days += 30;
			if (month == 12)
				break;

		}

		return days;
	}

	public String getWeekday() {
		int numberOfDays = (c.getYear() - c.getMinYear()) * 365
				+ numberOfLeapyears() + numberOfDaysCurrentYear();
		return days[numberOfDays % 7];

	}
}

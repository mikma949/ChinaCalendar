package calendar;
import java.util.Scanner;

public class MyCalendar {
	private int minYear = 1600, maxYear = 4000;
	private int year, month, day;



	public MyCalendar() {
		int inYear, inMonth, inDay;
		do {
			inYear = getInput("year");
		
		} while (!checkYear(inYear));
		year = inYear;

		do {
			inMonth = getInput("month");
		
		} while (!checkMonth(inMonth));
		month = inMonth;

		do {
			inDay = getInput("day");
			
		} while (!checkDay(inDay));
		day = inDay;

		if (validate()) {
			System.out.println("Correct date" +"\n");
			
		}
		
	}

	private int getInput(String value) {
		// TODO Auto-generated method stub
		int input = 0;

		Scanner myScanner = new Scanner(System.in);
		try {
			System.out.println("Enter " + value + ":");
			input = myScanner.nextInt();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid input, please enter an integer.");
			getInput(value);
		}
		return input;
	}

	private void printDate(int year, int month, int day) {
		// TODO Auto-generated method stub
		System.out.println(year + "-" + month + "-" + day + " is valid "
				+ validate() + "\n");
	}

	private boolean validate() {
		return (checkYear(year) && checkMonth(month) && checkDay(day));
	}

	private boolean checkDay(int day) {
		// TODO Auto-generated method stub
		switch (month) {
		case 2:
			if (!isLeapYear() && day > 28) {
				invalidDay();
				return false;
			}
			if (isLeapYear() && day > 29) {
				invalidDay();
				return false;
			}

			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day < 1 || day > 30) {
				invalidDay();
				return false;
			}

		default:
			if (day < 1 || day > 31) {
				invalidDay();
				return false;
			}
			break;
		}
	
		return true;
	}

	private boolean checkMonth(int month) {
		// TODO Auto-generated method stub
		if (month < 1 || month > 12) {
			System.out.println("Invalid month!");
			return false;
		}
		
		return true;
	}

	private boolean checkYear(int year) {
		// TODO Auto-generated method stub
		if (year >= minYear && year <= maxYear) {
		
			return true;
		}
		System.out.println("Invalid year!");
		return false;
	}

	public boolean isLeapYear() {
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
		System.out.println("Invalid day!");
	}

	// Returns {0,0,0} if invalid date.
	public int[] getNextDate() {
		if (checkDay(day + 1)) {
			day++;
		} else if (checkMonth(month + 1)) {
			day = 1;
			month++;
		} else if (checkYear(year + 1)) {
			day = 1;
			month = 1;
			year++;
		} else {
			day = month = year = 0;
		}
		int[] nextDate = { this.year, this.month, this.day };
		return nextDate;
	}

	public String getWeekday() {

		return "";
	}

	public int getMinYear() {
		return minYear;
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

	public int getMaxYear() {
		return maxYear;
	}
	public int[] getDate(){
		int[] date= {year,month,day};
		return date;
	}
}

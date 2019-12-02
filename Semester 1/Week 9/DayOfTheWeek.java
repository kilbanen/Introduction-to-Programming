import java.util.Scanner;
import javax.swing.JOptionPane;

public class DayOfTheWeek {
	
	public static final int MONTH_OF_JANUARY = 1;
	public static final int MONTH_OF_FEBRUARY = 2;
	public static final int MONTH_OF_MARCH = 3;
	public static final int MONTH_OF_APRIL = 4;
	public static final int MONTH_OF_MAY = 5;
	public static final int MONTH_OF_JUNE = 6;
	public static final int MONTH_OF_JULY = 7;
	public static final int MONTH_OF_AUGUST = 8;
	public static final int MONTH_OF_SEPTEMBER = 9;
	public static final int MONTH_OF_OCTOBER = 10;
	public static final int MONTH_OF_NOVEMBER = 11;
	public static final int MONTH_OF_DECEMBER = 12;
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int TH = 0;
	public static final int ST = 1;
	public static final int ND = 2;
	public static final int RD = 3;
	public static final int ONE_DIGIT = 10;
	public static final int TWO_DIGITS = 100;
	public static final int DAYS_IN_MONTH = 31;
	public static final int DAYS_IN_30_DAY_MONTH = 30;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_FEBRUARY = 28;
	public static final int IS_YEAR_DIVISIBLE_BY_FOUR = 4;
	public static final int IS_YEAR_DIVISIBLE_BY_100 = 100;
	public static final int IS_YEAR_DIVISBLE_BY_400 = 400;
	public static final int NO_REMAINDER = 0;

	public static void main(String[] args) {
		
		try
		{
			System.out.println("Enter a date (DD/MM/YYYY)");
			Scanner inputScanner = new Scanner(System.in);
			String date = inputScanner.nextLine();
			String[] splitDate = date.split("/");
			int day = Integer.parseInt(splitDate[0]);
			int month = Integer.parseInt(splitDate[1]);
			int year = Integer.parseInt(splitDate[2]);
		
			if(validDate(day, month, year))
			{
				System.out.println(dayOfTheWeek(day, month, year) + ", " + day + numberEnding(day) + " " + monthName(month) + " " + year);
			}
			else
			{
				System.out.println("Invalid date");
			}
		}
		catch(java.util.NoSuchElementException exception)
		{
			System.out.println("Invalid date");
		}

	}
	
	public static String numberEnding(int dayNumber)
	{
		int lastDigitOfDayNumber;
		if ((dayNumber % TWO_DIGITS == 11) || (dayNumber % TWO_DIGITS == 12) 
				                                           || (dayNumber % TWO_DIGITS == 13))
		{
			lastDigitOfDayNumber = TH;
		}
		else
		{
			lastDigitOfDayNumber =  dayNumber % ONE_DIGIT;
		}
		switch (lastDigitOfDayNumber)
		{
		case ST:
			return "st";
		case ND:
			return "nd";
		case RD:
			return "rd";
		default:
			return "th";
		}
		
	}
	
	public static String monthName(int monthNumber)
	{
		switch (monthNumber)
		{
		case MONTH_OF_JANUARY:
			return "January";
		case MONTH_OF_FEBRUARY:
			return "February";
		case MONTH_OF_MARCH:
			return "March";
		case MONTH_OF_APRIL:
			return "April";
		case MONTH_OF_MAY:
			return "May";
		case MONTH_OF_JUNE:
			return "June";
		case MONTH_OF_JULY:
			return "July";
		case MONTH_OF_AUGUST:
			return "August";
		case MONTH_OF_SEPTEMBER:
			return "September";
		case MONTH_OF_OCTOBER:
			return "October";
		case MONTH_OF_NOVEMBER:
			return "November";
		case MONTH_OF_DECEMBER:
			return "December";
		default:
			return "Invalid Month";
		}
		
	}
	
	
	public static String dayOfTheWeek(int day, int month, int year)
	{
		int passedYear = year;
		if (month == MONTH_OF_JANUARY)
		{
			passedYear--;
		}
		else if (month == MONTH_OF_FEBRUARY)
		{
			passedYear--;
		}
		
		int lastTwoDigitsOfYear = year % TWO_DIGITS;
		int firstTwoDigitsOfYear;
		for (firstTwoDigitsOfYear = year; firstTwoDigitsOfYear >= TWO_DIGITS;)
		{
			firstTwoDigitsOfYear /= ONE_DIGIT;
		}
		double dayOfWeek = (day + Math.floor(2.6 * (((month + 9) % 12) + 1) - 0.2) +
				                   lastTwoDigitsOfYear + Math.floor(lastTwoDigitsOfYear/4) + 
				          Math.floor(firstTwoDigitsOfYear/4) - (2 * firstTwoDigitsOfYear)) % 7;
		if (dayOfWeek < 0)
		{
			dayOfWeek += 7;
		}
		if (dayOfWeek == SUNDAY)
		{
			return "Sunday";
		}
		else if (dayOfWeek == MONDAY)
		{
			return "Monday";
		}
		else if (dayOfWeek == TUESDAY)
		{
			return "Tuesday";
		}
		else if (dayOfWeek == WEDNESDAY)
		{
			return "Wednesday";
		}
		else if (dayOfWeek == THURSDAY)
		{
			return "Thursday";
		}
		else if (dayOfWeek == FRIDAY)
		{
			return "Friday";
		}
		else if (dayOfWeek == SATURDAY)
		{
			return "Saturday";
		}
		else
		{
			return "Invalid day";
		}
	}
	
	public static boolean isLeapYear(int year)
	{
		if ((year % IS_YEAR_DIVISIBLE_BY_FOUR == NO_REMAINDER) && 
				                         (year % IS_YEAR_DIVISIBLE_BY_100 != NO_REMAINDER) || 
				                            (year % IS_YEAR_DIVISBLE_BY_400 == NO_REMAINDER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean validDate(int day, int month, int year)
	{
		if((day <= daysInMonth(month)) && (month >= MONTH_OF_JANUARY) && 
				                                                (month <= MONTH_OF_DECEMBER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int daysInMonth(int month)
	{
		switch(month)
		{
		case MONTH_OF_FEBRUARY:
			if(isLeapYear(MONTH_OF_FEBRUARY))
			{
				return DAYS_IN_FEBRUARY_IN_LEAP_YEAR;
			}
			else
			{
				return DAYS_IN_FEBRUARY;
			}
			
		case MONTH_OF_APRIL:
		case MONTH_OF_JUNE:
		case MONTH_OF_SEPTEMBER:
		case MONTH_OF_NOVEMBER:
			return DAYS_IN_30_DAY_MONTH;
		default:
			return DAYS_IN_MONTH;
		}
	}
	
}

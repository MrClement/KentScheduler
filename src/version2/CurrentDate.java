package version2;

import java.util.Calendar;

public class CurrentDate implements Comparable<CurrentDate> {

	private int year;
	private int month;
	private int day;
	private int dayOfTheWeek;

	public CurrentDate() {

	}

	public CurrentDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		calculateDayOfTheWeek();
		
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

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean equals(CurrentDate c) {
		return (c.getYear() == year && c.getMonth() == month && c.getDay() == day);

	}

	public String toString() {
		return "" + month + " " + day + " " + year;
	}

	public boolean isAfterOrEqual(CurrentDate other) {
		if (other.getYear() > year) {
			return false;
		} else if (other.getYear() < year) {
			return true;
		} else {
			if (other.getMonth() > month) {
				return false;
			} else if (other.getMonth() < month) {
				return true;
			} else {
				if (other.getDay() > day) {
					return false;
				} else if (other.getDay() < day) {
					return true;
				} else {
					return true;
				}
			}
		}
	}

	public boolean isAfter(CurrentDate other) {
		if (other.getYear() > year) {
			return false;
		} else if (other.getYear() < year) {
			return true;
		} else {
			if (other.getMonth() > month) {
				return false;
			} else if (other.getMonth() < month) {
				return true;
			} else {
				if (other.getDay() > day) {
					return false;
				} else if (other.getDay() < day) {
					return true;
				} else {
					return false;
				}
			}
		}

	}

	public boolean isBefore(CurrentDate other) {
		if (other.getYear() < year) {
			return false;
		} else if (other.getYear() > year) {
			return true;
		} else {
			if (other.getMonth() < month) {
				return false;
			} else if (other.getMonth() > month) {
				return true;
			} else {
				if (other.getDay() < day) {
					return false;
				} else if (other.getDay() > day) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public int compareTo(CurrentDate o) {
		if (equals(o)) {
			return 0;
		} else if (isBefore(o)) {
			return -1;
		} else
			return 1;
	}

	public int getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(int dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	
	public void calculateDayOfTheWeek() {
		Calendar today = Calendar.getInstance();
		today.clear();
		today.set(year, month - 1, day, 8, 8, 8);
		dayOfTheWeek = today.get(Calendar.DAY_OF_WEEK);
		
	}

	public void add(int i) {
			Calendar today = Calendar.getInstance();
			today.clear();
			today.set(year, month - 1, day, 8, 8, 8);
			today.add(Calendar.DATE, i);
			year = today.get(Calendar.YEAR);
			month = today.get(Calendar.MONTH)+1;
			day = today.get(Calendar.DAY_OF_MONTH);
			calculateDayOfTheWeek();


		
		
	}
		
	}


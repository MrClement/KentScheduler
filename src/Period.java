public class Period implements Comparable<Period> {

	private int number;
	private int startTime;
	private int endTime;

	public int getNumber() {
		return number;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public String toString() {
		return "st: " + startTime + " et: " + endTime + " num: " + number;
	}

	@Override
	public int compareTo(Period o) {
		int one = this.startTime;
		int two = o.startTime;
		if (one == two) {
			return 0;
		} else if (one > two) {
			return 1;
		} else {
			return -1;
		}
	}
}

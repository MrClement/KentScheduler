import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Day {

	private PriorityQueue<Period> d;
	private Period currentPeriod;
	private char dayType;

	public Day() {
		d = new PriorityQueue<>();
		currentPeriod = null;
	}

	public void add(Period p) {
		d.add(p);
	}

	public PriorityQueue<Period> getD() {
		return d;
	}

	public Period currentPeriod(int time) {
		for (Period p : d) {
			if (p.getStartTime() <= time && time <= p.getEndTime()) {
				currentPeriod = p;
				return p;
			}
		}
		return null;
	}

	public Period nextPeriod(int time) {
		currentPeriod = currentPeriod(time);
		PriorityQueue<Period> temp = new PriorityQueue<Period>();
		for (Period p : d) {
			temp.offer(p);
		}
		while (!temp.isEmpty()) {
			if (temp.remove().equals(currentPeriod)) {
				try {
					return temp.remove();
				} catch (NoSuchElementException e) {
					return null;
				}
			}

		}
		return null;

	}

	public String toString() {
		String line = "";
		for (Period p : d) {
			line += p.toString() + "\n";
		}
		return line;

	}

	public char getDayType() {
		return dayType;
	}

	public void setDayType(char dayType) {
		this.dayType = dayType;
	}

}

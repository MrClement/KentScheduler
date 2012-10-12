import java.util.Comparator;

public class PeriodComparator implements Comparator<Period> {

	@Override
	public int compare(Period o1, Period o2) {
		int one = o1.getStartTime();
		int two = o2.getStartTime();
		if (one == two) {
			return 0;
		} else if (one > two) {
			return 1;
		} else {
			return -1;
		}
	}
}

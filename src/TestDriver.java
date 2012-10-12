import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;

public class TestDriver {

	private static HashMap<CurrentDate, Day> calStorage;

	public static void main(String[] args) {

		CalParser cp = null;
		try {
			cp = new CalParser("AllPeriods.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calStorage = cp.getCalStorage();
		CurrentDate today = new CurrentDate(10, 11, 2012);
		int currentTime = 1730;
		for (Entry<CurrentDate, Day> c : calStorage.entrySet()) {
			if (c.getKey().equals(today)) {
				System.out.println(c.getValue().currentPeriod(currentTime).getNumber());
				System.out.println(c.getValue().nextPeriod(currentTime).getNumber());
			}
		}

	}
}

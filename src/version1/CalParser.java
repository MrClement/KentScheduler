package version1;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CalParser {

	private HashMap<CurrentDate, Day> calStorage;

	public HashMap<CurrentDate, Day> getCalStorage() {
		return calStorage;
	}

	public void addSpecialDays(HashMap<CurrentDate, Integer> sDays) {
		SpecialSchedule sMaker = new SpecialSchedule();
		// System.out.println(sDays.size());
		for (Entry<CurrentDate, Integer> e : sDays.entrySet()) {
			sMaker.makeSpecialDay(e.getValue(), e.getKey());
			calStorage.put(e.getKey(), sMaker.getSpecialDay());
		}
	}

	public CalParser(String filename) throws FileNotFoundException {

		calStorage = new HashMap<CurrentDate, Day>();
		Scanner scan = new Scanner(CalParser.class.getClassLoader().getResourceAsStream(filename));
		String line = "";
		while (scan.hasNext()) {
			line = scan.nextLine();
			String[] temp = line.split(":");
			Period p = new Period();
			CurrentDate d = new CurrentDate();
			if (temp[0].equals("BEGIN") && temp[1].equals("VEVENT")) {
				// Parse DTSTART
				line = scan.nextLine();
				// System.out.println(line);
				temp = line.split(":");
				if (temp[0].equals("DTSTART")) {
					String data = temp[1];
					d.setYear(Integer.parseInt(data.substring(0, 4)));
					d.setMonth(Integer.parseInt(data.substring(4, 6)));
					d.setDay(Integer.parseInt(data.substring(6, 8)));
					p.setStartTime(Integer.parseInt(data.substring(9, 13)));
					// System.out.println("" + d.getYear() + " " + d.getMonth()
					// + " " + d.getDay());
				} else {
					System.out.println("ERROR: Could not find start time!");
				}
				// Parse DTEND
				line = scan.nextLine();
				temp = line.split(":");
				if (temp[0].equals("DTEND")) {
					String data = temp[1];
					p.setEndTime(Integer.parseInt(data.substring(9, 13)));
					// System.out.println(p.getEndTime());
				} else {
					System.out.println("ERROR: Could not find end time!");
				}
				// Parse summary
				for (int i = 0; i < 9; i++) {
					scan.nextLine();
				}
				line = scan.nextLine();
				temp = line.split(":");
				if (temp[0].equals("SUMMARY")) {
					String data = temp[1];
					p.setNumber(Integer.parseInt(data.substring(data.indexOf(" ") + 1)));
					// System.out.println(p.getNumber());
				} else {
					System.out.println("ERROR: Could not find summary!");
				}
				// System.out.println("" + d + p);
				putInStorage(d, p);

			}
			// System.out.println("GOT HERE");

		}
		scan.close();

	}

	private void putInStorage(CurrentDate d, Period p) {

		for (Entry<CurrentDate, Day> c : calStorage.entrySet()) {
			if (c.getKey().equals(d)) {
				if (calStorage.get(c.getKey()) != null) {
					calStorage.get(c.getKey()).add(p);
					return;
				}
			}

		}
		Day day = new Day();
		day.add(p);
		calStorage.put(d, day);
	}
}

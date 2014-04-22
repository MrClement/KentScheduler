package version2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;

public class ScheduleServer {

	private static int port = 8080;
	private static int maxConnections = 0;
	private static HashMap<CurrentDate, Day> calStorage;
	private static CalParser cp;

	public static void main(String[] args) {

		ServerSocket myService = null;
		Socket clientSocket = null;
		int i = 0;

		cp = null;
		try {
			cp = new CalParser("AllPeriods.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		HashMap<CurrentDate, Integer> sDays = new HashMap<CurrentDate, Integer>();

		sDays.put(new CurrentDate(8, 20, 2013), 6);
		sDays.put(new CurrentDate(10, 11, 2013), 7);
		sDays.put(new CurrentDate(1, 17, 2014), 8);
		sDays.put(new CurrentDate(2, 28, 2014), 2);

		removeExistingDay(new CurrentDate(2, 11, 2014));
		sDays.put(new CurrentDate(2, 11, 2014), 9);

		removeExistingDay(new CurrentDate(3, 4, 2014));
		sDays.put(new CurrentDate(3, 4, 2014), 12);
		removeExistingDay(new CurrentDate(3, 5, 2014));
		sDays.put(new CurrentDate(3, 5, 2014), 10);
		removeExistingDay(new CurrentDate(3, 6, 2014));
		sDays.put(new CurrentDate(3, 6, 2014), 11);

		sDays.put(new CurrentDate(5, 2, 2014), 13);

		cp.addSpecialDays(sDays);
		calStorage = cp.getCalStorage();

		try {
			myService = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
			System.out.println("Started Schedule Server!");
		} catch (IOException e1) {
			System.out.println(e1);
		}

		try {
			while ((i++ < maxConnections) || (maxConnections == 0)) {
				ScheduleClientConnection connection;
				clientSocket = myService.accept();
				connection = new ScheduleClientConnection(clientSocket, calStorage);
				Thread t = new Thread(connection);
				t.start();
				System.out.println("Got client!");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void removeExistingDay(CurrentDate date) {
		CurrentDate test = null;
		for (Entry<CurrentDate, Day> c : cp.getCalStorage().entrySet()) {
			if (c.getKey().equals(date)) {
				test = c.getKey();
			}

		}
		cp.getCalStorage().remove(test);

	}
}

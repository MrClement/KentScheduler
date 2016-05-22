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

		/*
		 * SPECIAL SCHEDULE EXAMPLES
		 * 
		 * sDays.put(new CurrentDate(8, 20, 2013), 6);
		 * 
		 * 
		 * removeExistingDay(new CurrentDate(2, 11, 2014)); sDays.put(new
		 * CurrentDate(2, 11, 2014), 9);
		 */
		sDays.put(new CurrentDate(8, 25, 2015), 6);
		removeExistingDay(new CurrentDate(9, 1, 2015));
		sDays.put(new CurrentDate(9, 1, 2015), 18);
		removeExistingDay(new CurrentDate(10, 12, 2015));
		sDays.put(new CurrentDate(10, 12, 2015), 19);
		removeExistingDay(new CurrentDate(5, 27, 2016));
		sDays.put(new CurrentDate(5, 27, 2016), 20);
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

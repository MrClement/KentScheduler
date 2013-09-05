import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ScheduleServer {

	private static int port = 8080;
	private static int maxConnections = 0;
	private static HashMap<CurrentDate, Day> calStorage;

	public static void main(String[] args) {

		ServerSocket myService = null;
		Socket clientSocket = null;
		int i = 0;

		CalParser cp = null;
		try {
			cp = new CalParser("AllPeriods.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		HashMap<CurrentDate, Integer> sDays = new HashMap<CurrentDate, Integer>();
		// CurrentDate test = null;
		// for (Entry<CurrentDate, Day> c : cp.getCalStorage().entrySet()) {
		// if (c.getKey().equals(new CurrentDate(3, 5, 2013))) {
		// test = c.getKey();
		// }
		//
		// }
		// cp.getCalStorage().remove(test);
		// for (Entry<CurrentDate, Day> c : cp.getCalStorage().entrySet()) {
		// if (c.getKey().equals(new CurrentDate(4, 16, 2013))) {
		// test = c.getKey();
		// }
		//
		// }
		// cp.getCalStorage().remove(test);

		// sDays.put(new CurrentDate(12, 11, 2012), 0);
		sDays.put(new CurrentDate(8, 20, 2013), 6);
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
}

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.net.InetAddress;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

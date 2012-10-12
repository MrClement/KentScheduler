import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class ScheduleClientConnection implements Runnable {

	private Socket clientSocket;
	private String line;
	BufferedReader in;
	PrintStream out;

	private HashMap<CurrentDate, Day> calStorage;

	ScheduleClientConnection(Socket server, HashMap<CurrentDate, Day> calStorage) {
		clientSocket = server;
		this.calStorage = calStorage;
	}

	@Override
	public void run() {

		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintStream(clientSocket.getOutputStream());
			while ((line = in.readLine()) != null && !line.equals(".")) {
				String[] temp = line.split(" ");
				if (temp.length != 4) {
					out.println("Please enter the time and date in the following format: month day year time");
					out.println(".");
				} else {
					CurrentDate today = new CurrentDate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
							Integer.parseInt(temp[2]));
					Day thing = buildDay(today);
					int currentTime = Integer.parseInt(temp[3]);
					currentTime = adjustTime(currentTime, today, 1);
					// System.out.println(currentTime);
					// System.out.println(thing);
					if (thing != null) {
						Period tp;
						if ((tp = thing.currentPeriod(currentTime)) != null) {
							out.println(tp.getNumber() + " " + adjustTime(tp.getStartTime(), today, -1) + " "
									+ adjustTime(tp.getEndTime(), today, -1));
						} else {
							out.println("-8");
						}
						if ((tp = thing.nextPeriod(currentTime)) != null) {
							out.println(tp.getNumber() + " " + adjustTime(tp.getStartTime(), today, -1) + " "
									+ adjustTime(tp.getEndTime(), today, -1));
						} else {
							out.println("-8");
						}
						out.println(".");
					}
				}

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public int adjustTime(int time, CurrentDate today, int direction) {
		int currentTime = time;
		if (today.isBefore(new CurrentDate(11, 4, 2012)) || today.isAfterOrEqual(new CurrentDate(3, 10, 2013))) {
			currentTime += 600 * direction;
		} else {
			currentTime += 700 * direction;
		}
		return currentTime;

	}

	public Day buildDay(CurrentDate today) {
		Day temp = null;
		for (Entry<CurrentDate, Day> c : calStorage.entrySet()) {
			if (c.getKey().equals(today)) {
				temp = c.getValue();
			}

		}
		if (temp != null) {
			int firstPeriod = temp.getD().peek().getNumber();
			PriorityQueue<Period> tempQueue = new PriorityQueue<Period>();
			for (Period p : temp.getD()) {
				tempQueue.offer(p);
			}
			Period tp = new Period();
			Period tp2 = new Period();
			int breakStart;
			switch (firstPeriod) {
				case 1:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					tp2.setStartTime(breakStart + 20);
					tp2.setEndTime(breakStart + 40);
					tp2.setNumber(-2);
					temp.add(tp2);
					break;

				case 2:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					breakStart = tempQueue.poll().getEndTime();
					tp2.setStartTime(breakStart + 5);
					tp2.setEndTime(breakStart + 65);
					tp2.setNumber(-5);
					temp.add(tp2);
					break;

				case 3:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					tp2.setStartTime(breakStart + 20);
					tp2.setEndTime(breakStart + 40);
					tp2.setNumber(-3);
					temp.add(tp2);
					break;

				case 4:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					tp2.setStartTime(breakStart + 20);
					tp2.setEndTime(breakStart + 40);
					tp2.setNumber(-4);
					temp.add(tp2);
					break;
				case 5:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					tp2.setStartTime(breakStart + 20);
					tp2.setEndTime(breakStart + 40);
					tp2.setNumber(-2);
					temp.add(tp2);
					break;

				case 6:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					tp2.setStartTime(breakStart + 20);
					tp2.setEndTime(breakStart + 40);
					tp2.setNumber(-4);
					temp.add(tp2);
					break;

				case 7:
					tempQueue.poll();
					breakStart = tempQueue.poll().getEndTime();
					tp.setStartTime(breakStart);
					tp.setEndTime(breakStart + 20);
					tp.setNumber(-1);
					temp.add(tp);
					breakStart = tempQueue.poll().getEndTime();
					tp2.setStartTime(breakStart + 5);
					tp2.setEndTime(breakStart + 65);
					tp2.setNumber(-5);
					temp.add(tp2);
					break;
				default:
					break;
			}
		}
		return temp;
	}
}

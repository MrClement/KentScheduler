import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private static int port = 8080;

	public static void main(String[] args) {
		Socket myClient = null;
		String line;
		PrintStream out;
		Scanner s = new Scanner(System.in);
		BufferedReader in;

		try {
			myClient = new Socket("localhost", port);
		} catch (IOException e1) {
			System.out.println(e1);
		}

		try {

			while (true) {
				in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
				String input = "";
				line = s.nextLine();
				out = new PrintStream(myClient.getOutputStream());
				out.println(line);
				while ((input = in.readLine()) != null && !input.equals(".")) {
					System.out.println(input);
				}

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

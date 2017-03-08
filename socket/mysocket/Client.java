import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void start() {

		try {
			Socket socket = new Socket("127.0.0.1", 10056);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

			Scanner sc = new Scanner(System.in);
			String msg = "";
			String id = "" + (int) (Math.random() * 1000) + ":";
			while (true) {
				msg = sc.nextLine();
				pw.println(id + msg);
				pw.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client c = new Client();
		c.start();
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public void writeMsg(final Socket socket) {

		Thread writeThread = new Thread(() -> {

			PrintWriter pw = null;
			OutputStreamWriter osw = null;
			try {
				osw = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
				pw = new PrintWriter(osw);

				Scanner sc = new Scanner(System.in);
				String msg = "";
				String id = "" + (int) (Math.random() * 1000) + ":";

				while (true) {
					msg = sc.nextLine();
					pw.println(id + msg);
					pw.flush();
				}

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		writeThread.start();

	}

	public void readMsg(final Socket socket) {

		Thread readThread = new Thread(() -> {
			InputStreamReader isr = null;
			try {
				isr = new InputStreamReader(socket.getInputStream(), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				String msg = "";
				try {
					if (null != (msg = br.readLine())) {
						System.out.println(msg);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		readThread.start();

	}

	public void start() {

		Socket socket = null;
		try {
			socket = new Socket("192.168.1.109", 8000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writeMsg(socket);
		readMsg(socket);

	}

	public static void main(String[] args) {
		Client c = new Client();
		c.start();
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void start() {
		ServerSocket serversocket = null;
		try {
			serversocket = new ServerSocket(10056);
			System.out.println("server start...");

			while (true) {

				Socket socket = serversocket.accept();

				Thread thread = new Thread(() -> {

					String msg = "";
					BufferedReader br = null;
					try {
						br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						while (null != (msg = br.readLine())) {
							System.out.println(msg);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				thread.start();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != serversocket)
				try {
					serversocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		Server s = new Server();
		s.start();
	}

}

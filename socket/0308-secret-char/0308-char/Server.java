import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Server{

	public void start() throws Exception{
		ServerSocket server = new ServerSocket(8000);
		System.out.println("server ok...");

		while(true) {
			try {
				Socket socket = server.accept();
				chat(socket);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	private void chat(final Socket socket) {
		new Thread(new Runnable() {
			public void run() {
				InputStream input = null;
				BufferedReader br = null;

				try {
					ClientsManager cm = new ClientsManager();
					cm.addClient(socket);

					input = socket.getInputStream();
					br = new BufferedReader(new InputStreamReader(input, "utf-8"));
					String msg;
					while (null != (msg = br.readLine())) {
						System.out.println(msg);
						cm.brodcastMsg(msg);
					}

				} catch(Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (null != input) {
							input.close();
						}

						if (null != br) {
							br.close();
						}

						if (null != socket) {
							socket.close();
						}
					}catch(IOException ioe) {

					}
				}
				
			}
		}).start();
	}

}
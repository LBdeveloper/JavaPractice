import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class Server {
	
	public void start() {

		ServerSocket serversocket = new ServerSocket(10038);
		Socket socket = serversocket.accept();
		InputStream is = socket.getInputStream();
		byte[] temp = new byte[1024];
		int flag;
		while(-1!=(flag=is.read(byte[] temp))) {
			System.out.println(temp,0,flag);
		}


	}
}
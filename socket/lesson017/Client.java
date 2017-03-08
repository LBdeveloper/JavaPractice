import java.net.Socket;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException; 


public class Client{

	public void start() throws Exception{
		Socket socket = new Socket("127.0.0.1", 8000);
		writeMsg(socket);
	}

	public void writeMsg(Socket socket) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8") );
		//PrintWriter pw = new PrintWriter(socket.getOutputStream());
		String msg;
		while (null != (msg = br.readLine())) {
			String tmp = new String("王夫子:" + msg);
			pw.println(tmp);
			pw.flush();
		}
	}

}
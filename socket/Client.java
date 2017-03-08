import java.net.Socket;
import java.io.OutputStream;
import java.io.IOException;
import java.io.*;
import java.io.InputStreamReader; 

public class Client {

	public void start() throws IOException{
		
		Socket socket = new Socket("192.168.1.222", 8000);
		OutputStream ops = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(ops);
		String testS = "刘斌: Hello";
		pw.print(testS);
		pw.flush();
	}
	public static void main(String[] args) throws IOException {
		Client c = new Client();
		c.start();
	}





	// public void start() throws IOException {
	// 	Socket socket = new Socket("192.168.1.222",8000);
	// 	writeMsg(socket);
	// }


	// public void writeMsg(Socket socket) throws IOException{
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
	// 	String msg;
	// 	while(null != (msg = br.readLine())) {
	// 		String temp = new String("刘斌" + msg);
	// 		pw.println(temp);
	// 		pw.flush();
	// 	}
	// } 

	// public static void main(String[] args) throws IOException {
	// 	Client c = new Client();
	//  	c.start();
	// }


}
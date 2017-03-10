import java.net.Socket;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Iterator;

public class ClientsManager{
	private static final List<Socket> clients = new ArrayList<Socket>();

	public void addClient(Socket socket) {
		clients.add(socket);
	}

	public void brodcastMsg(String msg) {

		synchronized (ClientsManager.class) {
			Iterator<Socket> iter = clients.iterator();
			while (iter.hasNext()) {
				sendMsg(iter.next(), msg, iter);
			}
		}
	}


	private void sendMsg(Socket socket, String msg, Iterator<Socket> iter){
		OutputStreamWriter ost = null;
		PrintWriter pw = null;

		try {
			ost = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
			pw = new PrintWriter(ost);
			pw.println(msg);
			pw.flush();
		} catch(IOException e) {
			closeIO(ost, pw, socket);
			iter.remove();
		}
		
	}

	public void closeIO(OutputStreamWriter ost, PrintWriter pw, Socket socket) {
		try {
				if (null != ost) {
					ost.close();
				}

				if (null != pw) {
					pw.close();
				}

				if (null != socket) {
					socket.close();
				}

			} catch (IOException ioe) {

			}
	}

}
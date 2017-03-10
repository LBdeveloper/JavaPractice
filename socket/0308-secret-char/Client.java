import java.net.Socket;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStream;

public class Client{

	public void start() throws Exception{
		final Socket socket = new Socket("192.168.1.109", 8000);
		
		new Thread(new Runnable() {
			public void run() {
				try {
					writeMsg(socket);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				readMsg(socket);
			}
		}).start();
		
	}

	public void writeMsg(Socket socket) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8") );
		String msg;

		System.out.println("请输入用户名:");
		String username = br.readLine();
		pw.println("regist" + username);
		pw.flush();

		while (null != (msg = br.readLine())) {
			String flag = "";
			String context = msg;

			if (msg.length() < 1) {
				continue;
			}

			if("@".equals(msg.substring(0, 1))) {
				int spaceIndex = context.indexOf(" ");
				flag = context.substring(0, spaceIndex + 1);
				context = context.substring(spaceIndex + 1, context.length());
			}
			
			String tmp = new String(flag + username + ":" + context);
			System.out.println(tmp);
			pw.println(tmp);
			pw.flush();
		}
	}


	public void readMsg(Socket socket) {
		BufferedReader br = null;
		InputStream input = null;
		try {
			input = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(input, "utf-8"));
			String msg;
			while (null != (msg = br.readLine())) {
				System.out.println(msg);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

}
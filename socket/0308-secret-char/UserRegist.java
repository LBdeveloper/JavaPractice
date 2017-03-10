import java.util.Map;
import java.util.HashMap;
import java.net.Socket;


public class UserRegist{

	private static final Map<String, Socket> map = new HashMap<String, Socket>();

	public static void regist(String regMsg, Socket socket) {
		if (null == regMsg || "".equals(regMsg)) {
			return;
		}

		if (regMsg.length() <= 6) {
			return;
		}

		if(!"regist".equals(regMsg.substring(0, 6))) {
			return;
		}

		String username = regMsg.substring(6, regMsg.length());
		map.put(username, socket);
	}

	public static Socket getSocketByUsername(String username) {
		return map.get(username);
	}

	public static void main(String args[]) {
		String us = "@wxtkhello";
		int index = us.indexOf("k");
		System.out.println(us.substring(index + 1, us.length()));
		//System.out.println(us.substring(5, us.length()+1));
		//System.out.println(us.substring(5, us.length()-1));
	}

	
}
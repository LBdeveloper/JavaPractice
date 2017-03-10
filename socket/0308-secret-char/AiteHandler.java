import java.net.Socket;

public class AiteHandler{

	public static void processAiteMsg(String msg) {

		String username = msg.substring(1, msg.indexOf(" "));
		Socket socket = UserRegist.getSocketByUsername(username);
		if (null == socket) {
			return;
		}
		
		String context = msg.substring(username.length() + 2, msg.length());
		System.out.println(username + "=" + context);
		ClientsManager.sendMsg(socket, context);

	}

	public static boolean aiteFlag(String msg) {
		if (null == msg || "".equals(msg)) {
			return false;
		}

		if (msg.length() <= 2) {
			return false;
		}

		if(!"@".equals(msg.substring(0, 1))) {
			return false;
		}

		return true;
	}
}
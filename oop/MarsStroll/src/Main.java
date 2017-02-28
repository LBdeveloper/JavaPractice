import util.vehicle.*;
import signal.Signal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Vehicle marsCar = new MarsCar("夸父",5,"蓝色");
		// Signal s = new Signal("wd");
		// marsCar.printPosition();
		// marsCar.doMove(s);
		// marsCar.printPosition();

		while (true) {
			marsCar.printPosition();
			Scanner sc = new Scanner(System.in);
			String rawSignal = sc.next();
			Signal s = new Signal(rawSignal);
			marsCar.doMove(s);
			marsCar.printPosition();
			if("stop".equals(rawSignal)) {
				return ;
			}
		}
	
		
	}
}
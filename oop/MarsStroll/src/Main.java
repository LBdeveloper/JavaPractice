import util.vehicle.*;
import signal.Signal;

public class Main {
	public static void main(String[] args) {
		Vehicle marsCar = new MarsCar("夸父",5,"蓝色");
		Signal s = new Signal("wd");
		marsCar.printPosition();
		marsCar.doMove(s);
		marsCar.printPosition();

		

		
	}
}
package util.vehicle;

import signal.Signal;
import util.map.MarsMap;

public class MarsCar extends Vehicle {

	protected MarsMap marsmap;

	public MarsCar() {
		marsmap = new MarsMap();
	}

	public MarsCar(String name,int mass,String color) {
		this();
		this.name = name;
		this.mass = mass;
		this.color = color;

	}

	public void move(Signal s) {
		if(marsmap.isMove(s)) {
			System.out.println(marsmap.getDirDes());
		}else {
			System.out.println("不可以离开火星！！！");
		}
	}

	public void printPosition() {
		System.out.println(this+"在"+marsmap);
	}

	public String toString() {
		return ""+mass+"吨重的"+color+name+"火星车";
	}

}
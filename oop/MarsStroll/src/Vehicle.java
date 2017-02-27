package util.vehicle;

import signal.Signal;

public abstract class Vehicle {

    protected String name;
    protected int mass;
    protected String color;

    public abstract void move(Signal s);
    public abstract void printPosition();

    public void doMove(Signal s) {
    	move(s);
    }

    public void setName(String name) {
    	this.name = name;
    }

    public void setMass(int mass) {
    	this.mass = mass;
    }

    public void setColor(String color) {
    	this.color = color;
    }



}
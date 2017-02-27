package util.map;

import signal.Signal;

public class MarsMap {

    private final int scope = 9;
    private int x = 5;
    private int y = 5;

    private String dirdes;

    public String getDirDes() {
    	return dirdes;
    }

    public String toString() {
    	return "("+x+","+y+")";
    }

    public boolean isMove(Signal s) {
    	int temp_x = x;
    	int temp_y = y;
    	if(isLeagle(s)) {
    		return true;
    	}
    	
    		x = temp_x;
    		y = temp_y;
    		return false;
    	
    }

    private boolean isLeagle(Signal s) {
    	dirdes = "";
    	if(s.getIsUp()) {
    		++y;
    		dirdes = "向前移动1步";
    	}

    	if(s.getIsDown()) {
    		--y;
    		dirdes = "向后移动1步";
    	}

    	if(s.getIsLeft()) {
    		--x;
    		dirdes = dirdes+"向左移动1步";
    	}

    	if(s.getIsRight()) {
    		++x;
    		dirdes = dirdes+"向右移动1步";
    	}

    	if( x > 9 || x < 1 || y > 9 || y < 1 ) {
    		return false;
    	}

    	return true;
    }


}
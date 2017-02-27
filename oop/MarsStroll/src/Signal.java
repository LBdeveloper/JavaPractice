package signal;

public class Signal {

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

    public Signal() {
    	this("xx");
    }

    public boolean getIsUp() {
    	return isUp;
    }

    public boolean getIsDown() {
    	return isDown;
    }

    public boolean getIsLeft() {
    	return isLeft;
    }

    public boolean getIsRight() {
    	return isRight;
    }

    public Signal(String rawSignal) {
    	switch (rawSignal) {
    		case "w" : 
    		isUp = true;
    		break;

    		case "s" :
    		isDown = true;
    		break;

    		case "a" :
    		isLeft = true;
    		break;

    		case "d" :
    		isRight = true;
    		break;

    		case "wa" :
    		case "aw" :
    		isLeft = true;
    		isUp = true;
    		break;

    		case "wd" :
    		case "dw" :
    		isUp = true;
    		isRight = true;
    		break;

    		case "sa" :
    		case "as" :
    		isDown = true;
    		isLeft = true;
    		break;

    		case "ds" :
    		case "sd" :
    		isRight = true;
    		isDown = true;

    	}
    }

}
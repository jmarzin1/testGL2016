package td3;


public class MockKillRing implements IKillRing {
	public String trace;

    public MockKillRing() {
    	trace="MockKillRing():";
    }

    public void addElt(String s) {
        trace+="addElt(" + s + "):";
    }

    public void rotateForward() {
    	trace+="rotateForward():";
    }

    public boolean isEmpty() {
    	trace+="isEmpty():";
        return false;
    }

    public String currentElt() {
    	trace+="currentElt():";
        return "elt";
    }
    
    public String toString() {
    	trace+="toString():";
        return "";

    }

}

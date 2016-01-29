package td3;

public class MockBuffer implements IBuffer {

	public String trace;

    public MockBuffer(String s) {
        trace="MockBuffer(" + s +"):";
    }

    public void insert(String s, int position) {
    	trace+="insert(" + s + ", " + Integer.toString(position) +"):";
    }

    public void delete(int from, int to) {
    	trace+="delete(" + Integer.toString(from) + ", " + Integer.toString(to) +"):";
    }
    
    public String substring(int from, int to) {
    	trace+="substring(" + Integer.toString(from) + ", " + Integer.toString(to) +"):";
        return "";
    }

    public String toString() {
    	trace+="toString():";
        return "";
    }

    public int maxPosition() {
    	trace+="maxPosition():";
        return 1;
    }

}

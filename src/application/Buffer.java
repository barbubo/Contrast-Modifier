package application;

public class Buffer {
    private FullImage img;
    private boolean available = false;
    {
    	System.out.println("Buffer created");
    }

    public Buffer() {
        this.img = null;
    }
    
    public synchronized void put(FullImage img) {
    	while(available) {
    		try {
    			wait();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	available = true;
    	notifyAll();
    	this.img = img;
    	}
    
    public synchronized FullImage get() {
    	while(!available) {
    		try {
    			wait();
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	available = false;
    	notifyAll();
    	return img;
    }
}

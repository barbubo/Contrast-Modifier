package application;
import java.io.PipedOutputStream;

public class Consumer extends Thread {
    private Buffer buffer;
    private String args[];
    private PipedOutputStream pipedOutputStream;
    public Consumer(Buffer buffer, String[] args) {
        this.buffer = buffer;
        this.args = args;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void start() {
    	synchronized (buffer) {
	        FullImage img = buffer.get();
	        System.out.println("Consumer recieved the image");
	        long startTime = System.nanoTime();
			Double value = Double.valueOf(args[1]); //al doilea argument este valoarea cu care trebuie inmultita val pixelilor pt contrast
			String fullPath = args[2];
			String numeNou = args[3];
			fullPath = fullPath + '\\' + numeNou;
			img.modificareContrast(value);
			img.writeImg(fullPath);; //se scrie imaginea in calea noua
	        System.out.println("Image saved at: " + fullPath);
	        long endTime = System.nanoTime();
	        long totalTime = (endTime - startTime)/1000000;
	        System.out.println("Contrast modify execution time: " + totalTime +" ms");
	        buffer.notify();
    	}
    }
}
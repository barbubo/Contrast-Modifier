package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Producer extends Thread {
    private Buffer buffer;
    private String args[];
    {
    	
    }
    public Producer(Buffer buffer, String[] args) {
        this.buffer = buffer;
        this.args = args;
    }

    @Override
    public void start() {
    	long startTime = System.nanoTime();
    	String path = args[0]; //primul argument reprezinta calea de unde este luata imaginea
		FullImage img = new FullImage(); // obiect de tip poza
		img.readImg(path);
		long endTime = System.nanoTime();
        long totalTime = (endTime - startTime)/1000000;
        System.out.println("Image read execution time: " + totalTime +" ms");
		System.out.println("Producer is about to send the image");
        try {
            sleep(1000); // Așteaptă 1 secundă pentru a evidenția etapa de trimitere a imaginii
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer.put(img);
        System.out.println("Producer sent the image");
        
        try {
            sleep(1000); // Așteaptă 1 secundă pentru a evidenția etapa de finalizare
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     // Intră în starea "Not Runnable" după ce a terminat de pus imaginea în buffer
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
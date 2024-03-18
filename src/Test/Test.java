package Test;

import application.*;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		if (args.length < 4) { //verificare existenta parametri ai liniei de comanda; daca nu exista, se citesc de la tastatura
			String[] param = new String[4];
			Scanner keyboard = new Scanner(System.in); //initializare scanner
			System.out.println("The arguments are missing. Please write them"); //notificare ca argumentele nu exista
			System.out.println("\nImage Path:");
			param[0] = keyboard.nextLine(); //citirea path-ului imaginii (trebuie sa aiba extensia .bmp la final)
			System.out.println("\nContrast Value");
			param[1] = keyboard.nextLine(); //citirea factorului de contrast
			System.out.println("\nNew Image Path");
			param[2] = keyboard.nextLine(); //citirea path-ului in care trebuie scrisa imaginea noua
			System.out.println("\nNew Image Name");
			param[3] = keyboard.nextLine(); //citirea numelui noii imagini (trebuia sa aiba extensia .bmp la final)
			Buffer buffer = new Buffer(); //initializarea buffer-ului
		    Producer producer = new Producer(buffer, param); //initializarea producer-ului
		    Consumer consumer = new Consumer(buffer, param); //initializarea consumer-ului
		    producer.start(); //pornirea producer-ului
		    consumer.start(); //pornirea consumer-ului
		}
		else { //daca deja exista parametri ai liniei de comanda
		Buffer buffer = new Buffer(); //initializarea buffer-ului
	    Producer producer = new Producer(buffer, args); //initializarea producer-ului
	    Consumer consumer = new Consumer(buffer, args); //initializarea consumer-ului
	    producer.start(); //pornirea producer-ului
	    consumer.start(); //pornirea consumer-ului
		}
	}
} 

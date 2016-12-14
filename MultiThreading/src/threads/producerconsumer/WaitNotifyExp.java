package threads.producerconsumer;

import java.util.Scanner;

class Processor{
	
	public void produce() throws InterruptedException{
		synchronized(this){
			System.out.println("Producer thread running...");
			wait();
			System.out.println("Resumed");
		}
	}
	
	public void consume() throws InterruptedException{
		Scanner sr=new Scanner(System.in);
		Thread.sleep(2000);
		synchronized(this){
			System.out.println("Waiting for return key...");
			sr.nextLine();
			System.out.println("Return key pressed...");
			notify();
			Thread.sleep(3000);
			System.out.println("Exiting consumer thread...");
		}
	}
}

public class WaitNotifyExp {

	public static void main(String[] args) {
		Processor processor = new Processor();
		Thread t1=new Thread(()->{
			try {
				processor.produce();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2=new Thread(()->{
			try {
				processor.consume();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

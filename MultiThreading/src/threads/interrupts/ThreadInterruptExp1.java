package threads.interrupts;

import java.util.Random;

public class ThreadInterruptExp1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting ...");
		Thread t = new Thread(()->{
			Random random=new Random();
			for(int i=0;i<1E7;i++){
				if(Thread.currentThread().isInterrupted()){
					System.out.println("Interrupted");
					break;
				}
				Math.sin(random.nextDouble());
			}
		});
		
		t.start();
		Thread.sleep(500);
		t.interrupt();
		
		t.join();
		System.out.println("Finished ...");
	}

}

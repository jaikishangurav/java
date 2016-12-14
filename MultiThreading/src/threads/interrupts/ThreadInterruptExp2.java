package threads.interrupts;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadInterruptExp2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting ...");
		ExecutorService executor=Executors.newCachedThreadPool();
		Future<?> future = executor.submit(() ->{
			Random random=new Random();
			for(int i=0;i<1E7;i++){
				if(Thread.currentThread().isInterrupted()){
					System.out.println("Interrupted");
					break;
				}
				Math.sin(random.nextDouble());
			}
			return null;
		});
		
		executor.shutdown();
		Thread.sleep(500);
		
		future.cancel(true);
		executor.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("Finished ...");
	}

}

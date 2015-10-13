import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;


public class Service1Future {

	ExecutorService executor = Executors.newFixedThreadPool(2);
	
	@Async
	public Future<String> getService1Result(){
		
		Future<String> result = executor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				 String result = "Service1";
	                try {
	                    Thread.sleep(10000);
	                    
	                    System.out.println("Service 1 called");
	                    System.out.println(new Date());
	                } catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                return result;
			}
		});
		
		return result;
	}
}

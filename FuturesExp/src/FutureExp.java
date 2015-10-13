import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		/*executor.submit(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub				
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				System.out.println("Starting.....");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Finished....");
			}
			
		});*/
		
		Future<Integer> future = executor.submit(new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if(duration > 2000)
					throw new IOException("Sleeping for too long");
				
				System.out.println("Starting.....");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Finished....");
				
				return duration;
			}
			
		});
		System.out.println("+++++++++++++++++");
		try {
			System.out.println("Result : "+future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			IOException ioException = (IOException) e.getCause();
			System.out.println(ioException.getMessage());
		}
		
		executor.shutdown();
	}

}

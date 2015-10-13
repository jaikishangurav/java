import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class CallFutureServices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting : "+new Date());
		Future<String> service1 =new Service1Future().getService1Result();

		Future<String> service2 =new Service2Future().getService2Result();
		
		if(!service1.isDone() && !service2.isDone())
			System.out.println("Service not yet completed "+new Date());
		
		try {
			System.out.println("Service 1 result : "+service1.get());
			System.out.println("Service 2 result : "+service2.get());
			System.out.println("Completed : "+new Date());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Execution completed");
	}

}

/*ConcurrentHashMap supports full concurrency during retrieval. Means retrieval operation do not block even 
 * when add operation is running concurrently.
 * Read operations are fat while write operation require lock.Write lock is acquired on segment of map and not whole map.
 * Doesn't allow null key.If map.get(null) retruns null it cannot tell if null is not mapped or null is mapped to null value.
 * Operation are not atomic.
 * Though concurrenthashmap is concurrent it doesn't not give expected output when multiple threads are operating on it as operation are not atomic.
 * So have put and get operation in synchronized block or use atomic data types 
 * 
 * */

package collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentHashMapExp {
	
	static Map<String, AtomicLong> orders = new ConcurrentHashMap<>();

	static void processOrders(){
	for(String city : orders.keySet()){
		for(int i=0;i<10;i++){
			//synchronized(orders){
			//orders.put(city, orders.get(city)+1); //when synchronized block is used
			orders.get(city).getAndIncrement();
			//}
		}
	}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		orders.put("Bombay", new AtomicLong());
		orders.put("London", new AtomicLong());
		orders.put("Tokyo", new AtomicLong());
		orders.put("Beijing", new AtomicLong());
		
		ExecutorService executors = Executors.newFixedThreadPool(2);
		
		executors.submit(ConcurrentHashMapExp::processOrders);
		executors.submit(ConcurrentHashMapExp::processOrders);
		
		executors.awaitTermination(1, TimeUnit.SECONDS);
		executors.shutdown();
		
		System.out.println(orders);
		

	}

}

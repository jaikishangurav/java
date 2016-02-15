/*WeakHashMap is an implementation of the Map interface that stores only weak references to its keys. 
 * Storing only weak references allows a key-value pair to be garbagecollected 
 * when its key is no longer referenced outside of the WeakHashMap.
 * Keys inserted gets wrapped in java.lang.ref.WeakReference
 * 
 * Useful for cache/lookup storage
 * Weak Reference: If the only references to an object are weak references, 
 * the garbage collector can reclaim the object's memory at any time.
 * it doesn't have to wait until the system runs out of memory. 
 * Usually, it will be freed the next time the garbage collector runs.
 * 
 * */

package collections.map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExp {

	public static void main(String[] args) {
		Map<Order, Integer> orders = new WeakHashMap<>();
		orders.put(new Order(1,"assd"), 100); //Weak references
		//orders.put(new Order(2,"assd"), 102); //Weak references
		//orders.put(new Order(3,"assd"), 106); //Weak references
		
		
		Order o4 = new Order(4,"asdfg"); //Strong references
		orders.put(o4, 108);
				
		System.out.println(orders.size());
		
		o4=null;
		
		System.gc(); //Release memory held by weak references
		
		System.out.println(orders.size());

	}

}

class Order{
	int orderId;
	String details;
	
	public Order(int theId, String theDetails){
		orderId=theId;
		details=theDetails;
	}
}

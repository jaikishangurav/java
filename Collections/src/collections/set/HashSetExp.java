/* 1. Implements set interface backed by hashtable (actually a HashMap instance).
 * 2. It makes no guarantees as to the iteration order of the set; 
 *    in particular, it does not guarantee that the order will remain constant over time.
 * 3. This class permits the null element.
 * 4. This class offers constant time performance for the basic operations (add, remove, contains and size), 
 *    assuming the hash function disperses the elements properly among the buckets. 
 * 5. Iterating over this set requires time proportional to the sum of the HashSet instance's size (the number of elements) 
 *    plus the "capacity" of the backing HashMap instance (the number of buckets). 
 * 6. Note that this implementation is not synchronized. 
 * 7. If multiple threads access a hash set concurrently, and at least one of the threads modifies the set, it must be synchronized externally.
 *    This is typically accomplished by synchronizing on some object that naturally encapsulates the set.
 *    If no such object exists, the set should be "wrapped" using the Collections.synchronizedSet method.
 * 8. The iterators returned by this class's iterator method are fail-fast: if the set is modified at any time after the iterator is created, 
 *    in any way except through the iterator's own remove method, the Iterator throws a ConcurrentModificationException. 
 * */

package collections.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExp {

	public static void main(String[] args) {
		Set<Order> set = new HashSet<>();
		Order order1 = new Order(1,"sale");
		Order order2 = new Order(2,"market");
		Order order3 = new Order(1,"sale");
		System.out.println("hashcode of order1:"+order1.hashCode());
		System.out.println("hashcode of order2:"+order2.hashCode());
		System.out.println("hashcode of order3:"+order3.hashCode());
		System.out.println("order1==order3 ? "+order1.equals(order3));
		set.add(order1);
		set.add(order2);
		set.add(order3); //though order1 and order3
				
		System.out.println("Size of set :"+set.size());

	}
}
	
	class Order{
		int id;
		String name;
		
		public Order(int id, String name){
			this.id=id;
			this.name=name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Order other = (Order) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		
	}



/*Output:
 * [Hello, Namaste, Bonjour]
 * 
 * Output When hashcode and equals method is not overridden in Order class
 * hashcode of order1:705927765
 * hashcode of order2:366712642
 * hashcode of order3:1829164700
 * order1==order3 ? false
 * Size of set :3
 * 
 * Output When hashcode and equals method is overridden in Order class
 * hashcode of order1:3523623
 * hashcode of order2:-1081305029
 * hashcode of order3:3523623
 * order1==order3 ? true
 * Size of set :2
 * 
 *   
 * */

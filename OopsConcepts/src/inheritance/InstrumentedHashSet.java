package inheritance;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

//Broken - inappropriate use of inheritance
public class InstrumentedHashSet<E> extends HashSet<E> {
	// The number of attempted element insertions
	private int addCount=0;
	
	public InstrumentedHashSet(){
		
	} 
	
	public InstrumentedHashSet(int initCap, int loadFactor){
		super(initCap,loadFactor);
	}
	
	@Override
	public boolean add(E e){
		addCount++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c){
		addCount+=c.size();
		return super.addAll(c);
	}
	
	public int getAddCount(){
		return addCount;
	}
	
	public static void main(String[] args){
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(Arrays.asList("Snap","Crackle","Pop"));
		
		//method prints count as 6 instead of 3. Internally HashSet's addAll method is implemented on top of its add method, although HashSet does not document this detail. 
		//The addAll method in InstrumentedSet added three to addCount and then invoked HashSet's addAll implementation using super.addAll. 
		//This in turn invoked the add method, as overriden in InstrumentedHashSet, once for each element resulting in addCount method returning six.		
		System.out.println(s.getAddCount());
	}
}

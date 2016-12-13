import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NaturalNumber {

    private int i;

    public NaturalNumber(int i) { this.i = i; }
    // ...
}

class EvenNumber extends NaturalNumber {

    public EvenNumber(int i) { super(i); }
    // ...
}

public class WildCardUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EvenNumber> le = new ArrayList<>();
		List<? extends NaturalNumber> ln = le;
		//ln.add(new NaturalNumber(35));  // compile-time error
		
		List<NaturalNumber> l1 = new ArrayList<>();
		l1.add(new EvenNumber(4));
		l1.add(new NaturalNumber(4));
		foo(ln);
		
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<Double>  ld = Arrays.asList(10.10, 20.20, 30.30);
		swapFirst(li, ld);//While List<Integer> and List<Double> both fulfill the criteria of List<? extends Number>, it is clearly incorrect to take an item from a list of Integer values and attempt to place it into a list of Double values.
		
	}
	
	 static void foo(List<?> i) {
	       // i.set(0, i.get(0)); //WildcardError.java:6: error: method set in interface List<E> cannot be applied to given types;
		 //required: int,CAP#1
		  //found: int,Object
		  //reason: actual argument Object cannot be converted to CAP#1 by method invocation conversion
		  //where E is a type-variable:
		 fooHelper(i);
	    }
	 
	 static <T> void fooHelper(List<T> l){
		 l.set(0,l.get(0));
	 }
	 
	 static void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
	      Number temp = l1.get(0);
	      //l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
	                            // got a CAP#2 extends Number;
	                            // same bound, but different types
	      //l2.set(0, temp);	    // expected a CAP#1 extends Number,
	                            // got a Number
	      //There is no helper method to work around the problem, because the code is fundamentally wrong.
	    }

}

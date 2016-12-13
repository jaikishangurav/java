package exercise.three;

import java.util.Collection;

public class RelativelyPrimePredicate implements UnaryPredicate<Integer> {

	private Collection<Integer> c;
	
	RelativelyPrimePredicate(Collection<Integer> col){
		this.c=col;
	}
	@Override
	public boolean test(Integer x) {
		for(Integer i : c){
			if(Algorithm.gcd(x,i) !=1)
				return false;
		}
		return c.size()>0;
	}

}

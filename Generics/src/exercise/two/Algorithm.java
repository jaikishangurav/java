/*Write a generic method to find the maximal element in the range [begin, end) of a list.*/
package exercise.two;

import java.util.List;

public class Algorithm {

	public static <T extends Object & Comparable<? super T>> T maxEle(List<? extends T> ln, int begin, int end){
		T maxEle = ln.get(begin);
		for(++begin; begin<end; ++begin)
			if(maxEle.compareTo(ln.get(begin))<0)
				maxEle = ln.get(begin);
		return maxEle;
	}
}



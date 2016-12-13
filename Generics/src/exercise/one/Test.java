/*Write a generic method to count the number of elements in a collection that have a specific property 
 * (for example, odd integers, prime numbers, palindromes).*/
package exercise.one;

import java.util.Arrays;
import java.util.Collection;

public class Test {

    public static void main(String[] args) {
        Collection<Integer> c = (Collection) Arrays.asList(5, 4, 6, 21, 58, 62, 69);
        int count = Algorithm.countIf(c, new OddPredicate());
        System.out.println("Number of odd integers = " + count);
    }

}

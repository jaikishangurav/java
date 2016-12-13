/*How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?
public static <T>
    int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p)
Note that two integers a and b are relatively prime if gcd(a, b) = 1, where gcd is short for greatest common divisor.
 */
package exercise.three;
 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {

        List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicate<Integer> p = new RelativelyPrimePredicate(c);

        int i = Algorithm.findFirst(li, 0, li.size(), p);

        if (i != -1) {
            System.out.print(li.get(i) + " is relatively prime to ");
            for (Integer k : c)
                System.out.print(k + " ");
            System.out.println();
        }

    }
}
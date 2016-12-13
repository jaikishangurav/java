//Write a generic method to exchange the positions of two different elements in an array.

package exercise.four;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 4, 6, 21, 58, 62, 69);
        Algorithm.exchange(list, 1, 5);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

}

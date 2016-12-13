package exercise.one;

import java.util.Collection;

public class Algorithm {

    public static <T> int countIf(Collection<T> col, UnaryPredicate<T> p) {
        int count = 0;
        for (T t : col) {
            if (p.test(t))
                count++;
        }
        return count;
    }

}

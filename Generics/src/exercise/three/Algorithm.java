package exercise.three;

import java.util.List;

public class Algorithm {

    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
        for (; begin < end; ++begin) {
            if (p.test(list.get(begin)))
                return begin;
        }
        return -1;
    }

    public static int gcd(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) {
        }
        return y;
    }
}

package exercise.four;

import java.util.List;

public class Algorithm {

    public static <T> void exchange(List<T> list, Integer pos1, Integer pos2) {
        T temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2.intValue(), temp);
    }
}

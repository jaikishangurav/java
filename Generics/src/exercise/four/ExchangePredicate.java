package exercise.four;

import java.util.List;

public class ExchangePredicate implements UnaryPredicate<Integer> {

    List<Integer> list;

    ExchangePredicate(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean test(Integer obj) {
        return list.size() > obj ? true : false;
    }

}

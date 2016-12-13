import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCard<T> {

    /*
     * static void processList(List <? extends Number> numlist){ for(Number num : numlist){
     * System.out.println(num); } }
     */

    List<T> list = new ArrayList<T>();

    public void populate(T t) {
        list.add(t);
        processList(list);
    }

    static <T> void processList(List<T> numlist) {
        for (T num : numlist) {
            System.out.println(num);
        }
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        processList(list);
    }

    public static void printList(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void main(String args[]) {

        new WildCard<String>().populate("abc");

        List<Number> numlist = Arrays.asList(45, 12, 62, 41, 62, 45);
        List<Number> numlist1 = new <Number> ArrayList();
        processList(numlist);

        addNumbers(numlist1);

        // List <Integer> numlist1 = Arrays.asList(45,12,62,41,62,45);
        // processList(numlist1);

    }
}

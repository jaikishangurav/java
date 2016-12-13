
public class GenericImpl {

    public static void main(String[] args) {
        // Box<Integer> intBox = new Box<>();

        // Box rawBox = new Box();

        // Box<String> stringBox = new Box<>();
        // Box rawBox = stringBox;

        // rawBox = new Box(); // rawBox is a raw type of Box<T>
        // Box<Integer> intBox = rawBox; // warning: unchecked conversion
        Box<String> stringBox = new Box<>();
        stringBox.set("qwerty");
        System.out.println(stringBox.get().getClass());
        Box rawBox = stringBox;
        rawBox.set(8); // warning: unchecked invocation to set(T)
        System.out.println(rawBox.getClass() + "||" + rawBox.get().getClass());
        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        boolean same = Util.<Integer, String> compare(p1, p2);
        System.out.println(same);
    }

}

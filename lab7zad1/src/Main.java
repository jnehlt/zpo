import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        LazyList list = new LazyList(2f, 4f, 0.001f);
        int index = Collections.binarySearch(list, 0f);
        index = index > 0 ? index : (index + 1) * -1;
        System.out.println(index);
        System.out.println(list.at(index));
    }
}

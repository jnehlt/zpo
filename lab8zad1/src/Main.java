import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        MaxSearchAlgorithms msa = new MaxSearchAlgorithms();
        Class c = msa.getClass();
        Method [] m = c.getDeclaredMethods();

        int [] arg = {
                1, 4, 7, 28, 12, 6, 4, 12, 46, 12,
                4, 6, 3, 6, 1344, 14, 634, 36, 1,
                5115, 11, 6, 13451, 27, 6, 463, 2,
                62, 3, 347, 51, 23, 51, 725, 73, 35,
                21, 3, 42, 7, 4543, 361, 5, 1, 45134,
                51, 2, 47, 2131, 24, 3585, 61, 2, 7,
                4, 56, 2, 5, 23, 65, 8, 61, 5, 13, 4,
                4, 542, 37, 38, 3, 8, 53, 3, 2, 938
        };

        ArrayList<Integer> x;
        for(Method _m_ : m) {
            if(_m_.getName().contains("max")) {
                System.out.println(_m_.getName());
                x = (ArrayList<Integer>)_m_.invoke(msa, arg);
                for(Integer a : x) {
                    System.out.println(a);
                }
                System.out.println();
            }
        }
    }
}

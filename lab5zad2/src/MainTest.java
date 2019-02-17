import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void test() {
        Map<String, Integer> counts = new HashMap<>();
        String[] no_words = {"żeby", "dwa", "były", "żeby", "takie", "były", "same"};
        long start, end;

        start = System.nanoTime();
        Main.a(no_words, counts);
        end = System.nanoTime();
        System.out.println("a: " + (end - start));
        counts.clear();

        start = System.nanoTime();
        Main.b(no_words, counts);
        end = System.nanoTime();
        System.out.println("b: " + (end - start));
        counts.clear();

        start = System.nanoTime();
        Main.c(no_words, counts);
        end = System.nanoTime();
        System.out.println("c: " + (end - start));
        counts.clear();

        start = System.nanoTime();
        Main.d(no_words, counts);
        end = System.nanoTime();
        System.out.println("d: " + (end - start));
        counts.clear();

        start = System.nanoTime();
        Main.e(no_words, counts);
        end = System.nanoTime();
        System.out.println("e: " + (end - start));
        counts.clear();
    }
}
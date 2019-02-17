import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();
        String [] no_words = {"żeby", "dwa", "były", "żeby", "takie", "były", "same"};

        a(no_words, counts);
        counts.clear();
        b(no_words, counts);
        counts.clear();
        c(no_words, counts);
        counts.clear();
        d(no_words, counts);
        counts.clear();
        e(no_words, counts);
        counts.clear();
    }

    public static void a(String [] no_words, Map<String, Integer> counts) {
        for(String s : no_words) {
            if(counts.containsKey(s)) { counts.put(s, counts.get(s) + 1); }
            else { counts.put(s, 1); }
        }
    }

    public static void b(String [] no_words, Map<String, Integer> counts) {
        for(String s : no_words) {
            if(counts.get(s) != null) { counts.put(s, counts.get(s) + 1); }
            else { counts.put(s, 1); }
        }
    }

    public static void c(String [] no_words, Map<String, Integer> counts) {
        for(String s : no_words) {
            if(counts.getOrDefault(s, -1) != -1) { counts.put(s, counts.get(s) + 1); }
            else { counts.put(s, 1); }
        }
    }

    public static void d(String [] no_words, Map<String, Integer> counts) {
        for(String s : no_words) {
            if(counts.putIfAbsent(s, 1) != null ) { counts.put(s, counts.get(s) + 1); }
        }
    }

    public static void e(String [] no_words, Map<String, Integer> counts) {
        for(String s : no_words) {
            counts.merge(s, 1, Integer::sum);
        }
    }
}

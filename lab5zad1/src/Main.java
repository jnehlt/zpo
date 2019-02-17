import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String> gunwo = null;
        Stream<String> min = null;
        Stream<String> max = null;

        try {
            min = Files.lines(Paths.get("src/dane.txt"));
            max = Files.lines(Paths.get("src/dane.txt"));
            gunwo = Files.lines(Paths.get("src/dane.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if(min == null || max == null || gunwo == null) {
            System.out.println("error");
            return;
        }

        Integer sum_of_minimum = min
                .filter(x->x.contains(" PL "))
                .map(x -> x.split(" ")[3])
                .mapToInt(Integer::valueOf)
                .sorted()
                .limit(2)
                .sum();
        System.out.println(sum_of_minimum);

        Integer sum_of_maximum = max
                .filter(x->x.contains(" PL "))
                .map(x -> x.split(" ")[3])
                .mapToInt(Integer::valueOf)
                .map(x -> -x)
                .sorted()
                .map(x -> -x)
                .limit(2)
                .sum();
        System.out.println(sum_of_maximum);

        List<String> gunwo_out = gunwo
                .map(x -> x.split(" ")[2])
                .collect(Collectors.toList());

        while( ! gunwo_out.isEmpty()) {
            Integer temp = 0;
            String cmp = gunwo_out.get(0);
            for(String s : gunwo_out) {
                if(s.equals(cmp)) {
                    temp++;
                }
            }
            System.out.println(cmp + " - " + temp);
            gunwo_out.removeIf(x -> cmp.equals(x));
        }
    }
}

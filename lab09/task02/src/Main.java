import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Long> primes = Prime.getPrimes(Long.valueOf(1), Long.valueOf(40));
        primes.sort(Long::compareTo);

        ArrayList<Pair> pairs = new ArrayList<>();

        for(int i = primes.size() - 1; i > 0; i--){
            if(Math.abs(primes.get(i) - primes.get(i - 1)) == 2){
                if(pairs.size() < 5){
                    pairs.add(new Pair(primes.get(i), primes.get(i-1)));
                } else {
                    break;
                }
            }
        }
        
        primes.forEach(System.out::println);
        System.out.println("===============");
        pairs.forEach(System.out::println);
    }
}

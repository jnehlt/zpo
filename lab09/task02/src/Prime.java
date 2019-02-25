import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Prime extends RecursiveTask<CopyOnWriteArrayList<Long>> {
    static final int THRESHOLD = 100;
    Long low, high;
    CopyOnWriteArrayList<Long> listOfPrime;

    public Prime(Long low, Long high){
        this.low = low;
        this.high = high;
        listOfPrime = new CopyOnWriteArrayList<>();
    }

    @Override
    protected CopyOnWriteArrayList<Long> compute() {
        if(high - low <= THRESHOLD){
            for(Long i = low; i < high; i++){
                if(isPrime(i))
                    listOfPrime.add(i);
            }
            return listOfPrime;
        } else {
            Long mid = low + (high - low) / 2;
            Prime left = new Prime(low, mid);
            Prime right = new Prime(mid, high);
            left.fork();
            CopyOnWriteArrayList<Long> rightAns = right.compute();
            CopyOnWriteArrayList<Long> leftAns = left.join();
            leftAns.addAll(rightAns);
            return leftAns;
        }
    }

    static CopyOnWriteArrayList<Long> getPrimes(Long low, Long high){
        return ForkJoinPool.commonPool().invoke(new Prime(low, high));
    }

    static boolean isPrime(Long number){
        if(number == 1)
            return false;
        if(number == 2 || number == 3)
            return true;

        if(number > 3){
            if(number % 2 == 0)
                return false;

            for(int i = 3; i <= Math.sqrt(number); i+=2){
                if(number % i == 0)
                    return false;
            }
        }

        return true;
    }
}

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Person implements Callable<Boolean> {
    static Random random = new Random();
    static volatile int readyToWatch = 0;

    @Override
    public Boolean call() throws Exception {
        int timeForDecision = random.nextInt(Main.timeForDecision) + 1;
        TimeUnit.SECONDS.sleep(timeForDecision);
        if(random.nextFloat() <= Main.p1){
            System.out.println("IDE KURŁA... myślałem nad tym filem " + timeForDecision + " sekundy");
            readyToWatch++;
            return true;
        }else{
            return false;
        }
    }
}

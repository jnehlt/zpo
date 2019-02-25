import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Spectator implements Callable<Boolean> {
    static Random random = new Random();
    static volatile int spectatorQuantity = 0;

    @Override
    public Boolean call() throws Exception {
        TimeUnit.SECONDS.sleep(Main.movieLength / 2);
        if(random.nextFloat() <= Main.p2){
            System.out.println("ŁEE GUNWO...");
            spectatorQuantity--;
            if(spectatorQuantity < Main.minimumSpectatorQuantity){
                throw new CinemaException("Jesteście frajerami i nie zwrócimy wam hajsu");
            }
            return false;
        }else{
            return true;
        }
    }
}

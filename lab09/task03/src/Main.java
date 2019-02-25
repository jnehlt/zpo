import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static int N = 100;
    public static float p1 = 0.05f;
    public static float p2 = 0.3f;
    public static int minimumSpectatorQuantity = 5;
    public static int timeForDecision = 4;
    public static int movieLength = 4;

    public static void main(String[] args) throws InterruptedException, CinemaException {
        List<Person> personList = new ArrayList<>(N);

        for(int i = 0; i < N; i++){
            personList.add(new Person());
        }
        ExecutorService executorService = Executors.newScheduledThreadPool(N);
        executorService.invokeAll(personList);

        if(Person.readyToWatch < minimumSpectatorQuantity){
            throw new CinemaException("Przepraszamy, filmu nie będzie.");
        }

        List<Spectator> spectatorList = new ArrayList<>(Person.readyToWatch);
        Spectator.spectatorQuantity = Person.readyToWatch;

        for(int i = 0; i < Person.readyToWatch; i++){
            spectatorList.add(new Spectator());
        }

        ExecutorService executorService2 = Executors.newScheduledThreadPool(Person.readyToWatch);
        executorService2.invokeAll(spectatorList);

        executorService.shutdown();
        executorService2.shutdown();
    }
}

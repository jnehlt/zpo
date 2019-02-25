import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Threads extends Thread{
    public static volatile boolean ready = false;

    String string;
    static Queue<Thread> threads = new LinkedBlockingQueue<>();

    public Threads(String string){
        this.string = string;
        threads.add(this);
        start();
    }

    @Override
    public synchronized void run(){
        super.run();

        for(int i = 0; i < string.length(); i++){
            while(threads.peek() != this || !ready);
            synchronized(threads){
                Thread temp = threads.poll();

                if(temp == null){
                    return;
                }

                System.out.print(string.charAt(i));

                if(i <= string.length()){
                    threads.add(temp);
                }
            }
        }
        threads.remove(this);
    }
}

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws Exception {
        Integer port = 65432;
        ServerSocket SS = new ServerSocket(port);
        Socket CS = SS.accept();

        BufferedReader from = new BufferedReader(
                new InputStreamReader(
                        CS.getInputStream()
                )
        );
        DataOutputStream to = new DataOutputStream(
                CS.getOutputStream()
        );

        String min = from.readLine().replaceAll("\0", "");
        String max = from.readLine().replaceAll("\0", "");

        to.writeChars(calcPrime(min, max));
    }

    private static String calcPrime(String start, String stop) throws Exception {
        Long st = Long.valueOf(start);
        Long end = Long.valueOf(stop);
        Random r = new Random();
        float pr = r.nextFloat() * 0.3f + 0.61f;
        long ran = end - st;
        long div = (int)(st + ran * pr);
        Counter first = new Counter(st, div);
        Counter second = new Counter(div+1, end);

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        Long startTime = System.nanoTime();

        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();

        Long stopTime = System.nanoTime();

        return String.valueOf(
                    first.getResult()
                    + second.getResult()
                )   + "\n"
                    + String.valueOf(stopTime - startTime)
                    + "\n";
    }
}

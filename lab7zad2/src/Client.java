import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        Integer port = 65432;
        Socket sock = new Socket(host, port);

        BufferedReader from = new BufferedReader(
                new InputStreamReader(
                        sock.getInputStream()
                )
        );
        DataOutputStream to = new DataOutputStream(
                sock.getOutputStream()
        );

        Long min = 5L;
        Long max = 5000232L;
        to.writeChars(min.toString() + "\n" + max.toString() + "\n");

        String primesFound = from.readLine().replaceAll("\0", "");
        String executionTime = from.readLine().replaceAll("\0", "");

        System.out.println("Primes Found: "
                + primesFound
                + "\nIn range: [ "
                + min
                + " - "
                + max
                + " ]\n"
                + "Execution Time: "
                + executionTime
                + "ns.\n\n"
        );
    }
}

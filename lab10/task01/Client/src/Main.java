import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // krok 1
        System.out.print("Podaj nr indeksu_");
        Scanner scanner = new Scanner(System.in);
        String nrIndeksu = scanner.nextLine();

        // krok 2
        Socket socket = new Socket("localhost", 1337);
        DataOutputStream  sender = new DataOutputStream(socket.getOutputStream());
        sender.writeBytes(nrIndeksu + '\n');

        // krok 3
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Student student = (Student)objectInputStream.readObject();
        System.out.println(student);
        System.out.print("Wpisać ocenę t/n?_");
        String decision = scanner.nextLine();

        // krok 4
        if(decision.contains("t")){
            System.out.print("Podaj ocenę_");
            Integer ocena = scanner.nextInt();
            student.dodajOcene(ocena);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(student);
        }

        // krok 5
        socket.close();
        System.exit(0);

    }
}

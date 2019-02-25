import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        // krok 1
        ArrayList<Student> listaStudentow = new ArrayList<>();
        listaStudentow.add(new Student("Artur", "Mokrosinski", 209397));
        listaStudentow.add(new Student("Maciej", "Nabiałczyk", 209404));
        listaStudentow.add(new Student("Jakub", "Czaja", 209290));

        while(true) {
            // krok 2
            ServerSocket serverSocket = new ServerSocket(1337);
            Socket socket = serverSocket.accept();

            // krok 3
            BufferedReader receiver =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            System.out.println("x1");
            String nrIndeksu = receiver.readLine();
//            String ndsa = "209397";
//            System.out.println("x2:" + nrIndeksu + ":" + Integer.parseInt("2012312"));
            Student student = null;

            int index = -1;
            // krok 4
            for(int i = 0; i < listaStudentow.size(); i++){
                if(listaStudentow.get(i).getNrIndeksu() == Integer.parseInt(nrIndeksu)){
                    student = listaStudentow.get(i);
                    index = i;
                }
            }
            if(index == -1){
                throw new Exception();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(student);

            // krok 5
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Student nowyStudent = (Student) objectInputStream.readObject();

                if (nowyStudent != null) {
                    listaStudentow.remove(index);
                    listaStudentow.add(nowyStudent);
                }
            }catch (Exception e){
                System.out.println(e.getStackTrace());
            }finally {
                // krok 6
                serverSocket.close();
                socket.close();
            }
        }
    }
}

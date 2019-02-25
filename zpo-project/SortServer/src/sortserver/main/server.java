package sortserver.main;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class server
{

    private static Socket socket;

    public static void main(String[] args)
    {
        try
        {
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");

            while(true)
            {
                socket = serverSocket.accept();
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
                try
                {
                    ArrayList<String> s = (ArrayList<String>)is.readObject();
                    System.out.println("Message received from client is " + s);
                }
                catch (ClassCastException exception)
                {
                    System.out.println(exception.getMessage());
                }

                String returnMessage = "Message recieved";
                String sendreturnMessage = returnMessage + "\n";

                //send back to client
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(sendreturnMessage);
                bw.flush();
                System.out.println("Message sent to the client is "+returnMessage);
                System.out.println("\nProcess Complete\n");
            }
        }
        catch (UnknownHostException |ConnectException exception)
        {
            System.out.println(exception.getMessage());
        }
        catch (SocketException exception)
        {
            System.out.println(exception.getMessage());
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            try
            {
                if (socket != null && socket.isConnected())
                {
                    socket.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

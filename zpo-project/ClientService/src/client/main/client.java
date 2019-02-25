package client.main;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class client
{
    private static Socket sortServerSocket;

    public static void main(String args[])
    {
        try
        {
            String host = "localhost";
            int sortServerPort = 25000;
            InetAddress address = InetAddress.getByName(host);
            sortServerSocket = new Socket(address, sortServerPort);

            //Send the message to the server
            ObjectOutputStream objToSend = new ObjectOutputStream(sortServerSocket.getOutputStream());
            List<String> messageToSend = Files.readAllLines(Paths.get("names.txt"), Charset.defaultCharset());
            objToSend.writeObject(messageToSend);
            System.out.println("Message sent to the server");

            //Get the return message from the server
            InputStream is = sortServerSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message);
        }
        catch (UnknownHostException|ConnectException exception)
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
                if (sortServerSocket != null && sortServerSocket.isConnected())
                {
                    sortServerSocket.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

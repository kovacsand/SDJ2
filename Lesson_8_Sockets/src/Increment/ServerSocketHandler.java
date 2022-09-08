package Increment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private Counter counter;
  private ObjectInputStream in;
  private ObjectOutputStream out;

  public ServerSocketHandler(Socket socket, Counter counter) throws IOException
  {
    this.socket = socket;
    this.counter = counter;
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
    System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        String message = (String) in.readObject();
        if (message.equals("increment"))
        {
          counter.incrementCount();
        }
        else if (message.equals("get"))
        {
          System.out.println("sending value");
          out.writeObject(counter.getCounter() + "");
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}

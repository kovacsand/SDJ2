package ThreadsBothSides.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectOutputStream out;
  private ObjectInputStream in;

  public ClientSocketHandler(Socket socket) throws IOException
  {
    this.socket = socket;
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    String id = "";
    try
    {
      id = (String) in.readObject();
      System.out.println(id);
      while (true)
      {
        out.writeObject("Hello from TimeStamp.client number " + id);
        System.out.println(in.readObject());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

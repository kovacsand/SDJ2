package ThreadsBothSides.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private int id;

  public ServerSocketHandler(Socket socket, int id)
  {
    this.socket = socket;
    this.id = id;
  }

  @Override public void run()
  {
    try
    {
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());

      out.writeObject(id + "");

      while (true)
      {
        System.out.println(in.readObject());
        out.writeObject("And hello to you, TimeStamp.client number " + id);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

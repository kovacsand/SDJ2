package Increment;

import Chat.client.networking.ClientSocketHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client
{
  private Socket socket;
  private ObjectInputStream in;
  private ObjectOutputStream out;

  public Client() throws IOException
  {
    socket = new Socket("127.0.0.1", 1209);
    in = new ObjectInputStream(socket.getInputStream());
    out = new ObjectOutputStream(socket.getOutputStream());
  }

  public void start()
      throws IOException, ClassNotFoundException, InterruptedException
  {
    for (int i = 0; i < 1000000; i++)
      out.writeObject("increment");
    System.out.println("finished incrementing");
    out.writeObject("get");
    System.out.println(in.readObject());
  }
}

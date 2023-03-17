package Chat.server;

import Chat.transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private String username;
  private Pool pool;
  private ObjectInputStream in;
  private ObjectOutputStream out;

  public ServerSocketHandler(Socket socket, String username, Pool pool)
      throws IOException
  {
    this.socket = socket;
    this.username = username;
    this.pool = pool;
    in = new ObjectInputStream(socket.getInputStream());
    out = new ObjectOutputStream(socket.getOutputStream());

    System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());
    out.writeObject("Hello " + username);
  }

  public void sendMessage(Message msg) throws IOException
  {
    out.writeObject(msg);
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        pool.broadcast((Message) in.readObject());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

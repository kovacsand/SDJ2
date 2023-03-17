package server.networking;

import shared.transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable
{
  private Socket socket;
  private String username;
  private Pool pool;
  private ObjectInputStream in;
  private ObjectOutputStream out;

  public SocketHandler(Socket socket, String username, Pool pool)
      throws IOException
  {
    this.socket = socket;
    this.username = username;
    this.pool = pool;
    in = new ObjectInputStream(socket.getInputStream());
    out = new ObjectOutputStream(socket.getOutputStream());
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
        Message message = (Message) in.readObject();
        if (message.getSender().equals("ClientSystem") && message.getMsg().equals("GetAllMessages"))
        {
          out.writeObject(pool.getAllMessages().clone());
        }
        else
        {
          pool.broadcast(message);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


package Ex_11_5.Server;


import Ex_11_5.transferObjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private ServerMain1 server;
  private Socket socket;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private int id;

  public ServerSocketHandler(Socket socket, int id, ServerMain1 server)
      throws IOException
  {
    this.socket = socket;
    this.server = server;
    this.id =id;
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      out.writeObject(id);

        while (true)
        {
            Message message = (Message) in. readObject();
            System.out.println(message.getMsg() + " from: " + message.getId());

            server.getPool().broadcast(message.getMsg(), message.getId());
        }

    }

    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(Message message)
  {
    try
    {
      out.writeObject(message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}

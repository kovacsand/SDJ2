package Chat.client.networking;

import Chat.transferobjects.Message;

import java.io.IOException;
import java.net.Socket;

public class SocketClient
{
  private ClientSocketHandler csh;

  public void start() throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 1209);
    csh = new ClientSocketHandler(socket, this);
    new Thread(csh).start();
  }

  public void sendMessage(String msg) throws IOException
  {
    csh.sendMessage(msg);
  }

  public void messageReceived(Message msg)
  {
    System.out.println(msg.toString());
  }
}

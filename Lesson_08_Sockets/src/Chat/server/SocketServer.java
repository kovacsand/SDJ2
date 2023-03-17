package Chat.server;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  public void startServer()
  {
    try (ServerSocket serverSocket = new ServerSocket(1209))
    {
      Pool pool = new Pool();
      String[] usernames = {"Ava", "Barb", "Casie", "Diana", "Emily"};
      int counter = 0;
      while (true)
      {
        Socket socket = serverSocket.accept();
        ServerSocketHandler ssh = new ServerSocketHandler(socket, usernames[counter++], pool);
        pool.addConnection(ssh);
        new Thread(ssh).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

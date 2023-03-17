package server.networking;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  public void startServer()
  {
    try (ServerSocket serverSocket = new ServerSocket(1209))
    {
      System.out.println("Server is running");
      Pool pool = new Pool();
      String[] usernames = {"Ava", "Barb", "Casie", "Diana", "Emily"};
      int counter = 0;
      while (true)
      {
        Socket socket = serverSocket.accept();
        SocketHandler ssh = new SocketHandler(socket, usernames[counter++], pool);
        pool.addConnection(ssh);
        new Thread(ssh).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

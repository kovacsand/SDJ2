package ThreadsBothSides.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public void start()
  {
    try (ServerSocket serverSocket = new ServerSocket(1235))
    {
      int counter = 0;
      while (true)
      {
        Socket socket = serverSocket.accept();
        Thread t = new Thread(new ServerSocketHandler(socket, counter++));
        t.start();
      }
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

package Increment;

import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public void start()
  {
    Counter counter = new Counter();
    try (ServerSocket serverSocket = new ServerSocket(1209))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        ServerSocketHandler ssh = new ServerSocketHandler(socket, counter);
        new Thread(ssh).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

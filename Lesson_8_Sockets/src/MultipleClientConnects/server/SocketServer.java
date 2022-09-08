package MultipleClientConnects.server;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  public void startServer()
  {
    StringModel sm = new StringModel();
    try (ServerSocket serverSocket = new ServerSocket(1235))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        Thread t = new Thread(new ServerSocketHandler(socket, sm));
        t.start();
      }
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}

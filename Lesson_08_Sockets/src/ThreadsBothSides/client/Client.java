package ThreadsBothSides.client;

import java.io.IOException;
import java.net.Socket;

public class Client
{
  public void start() throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 1235);
    Thread t = new Thread(new ClientSocketHandler(socket));
    t.start();
  }
}

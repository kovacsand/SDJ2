package Chat.server;

public class RunServer
{
  public static void main(String[] args)
  {
    SocketServer server = new SocketServer();
    server.startServer();
  }
}

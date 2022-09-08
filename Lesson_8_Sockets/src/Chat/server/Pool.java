package Chat.server;

import Chat.transferobjects.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pool
{
  private List<ServerSocketHandler> connections;

  public Pool()
  {
    connections = new ArrayList<>();
  }

  public synchronized void broadcast(Message message)
  {
    for (ServerSocketHandler ssh : connections)
    {
      try
      {
        ssh.sendMessage(message);
      }
      catch (IOException e)
      {
        connections.remove(ssh);
        e.printStackTrace();
      }
    }
  }

  public synchronized void addConnection(ServerSocketHandler ssh)
  {
    connections.add(ssh);
  }
}

package Ex_11_5.Server;

import Ex_11_5.transferObjects.Message;

import java.util.ArrayList;
import java.util.List;

public class Pool
{
  private List<ServerSocketHandler> connections;

  public Pool()
  {
    connections =  new ArrayList<>();

  }

  public synchronized void broadcast(String msg, int id)
  {
    Message message = new Message(msg, id);
    for(ServerSocketHandler conn: connections )
    {
      conn.sendMessage(message);
    }
  }
  public synchronized void  addConn(ServerSocketHandler ssh)
  {
    connections.add(ssh);
  }
  public synchronized void  removeConn(ServerSocketHandler ssh)
  {
    connections.remove(ssh);
  }

}

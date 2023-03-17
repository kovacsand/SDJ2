package server.networking;

import shared.transferobjects.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pool
{
  private List<SocketHandler> connections;
  private ArrayList<Message> allMessages;

  public Pool()
  {
    connections = new ArrayList<>();
    allMessages = new ArrayList<>();
  }

  public synchronized void broadcast(Message message)
  {
    addMessage(message);
    for (SocketHandler ssh : connections)
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

  public synchronized void addConnection(SocketHandler ssh)
  {
    connections.add(ssh);
  }

  private void addMessage(Message message)
  {
    allMessages.add(message);
  }

  public ArrayList<Message> getAllMessages()
  {
    return allMessages;
  }
}

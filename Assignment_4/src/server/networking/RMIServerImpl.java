package server.networking;

import server.model.ChatManager;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIServerImpl implements RMIServer
{
  private final ChatManager chatManager;
  private Map<ClientCallBack, PropertyChangeListener> clients = new HashMap<>();

  public RMIServerImpl(ChatManager chatManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.chatManager = chatManager;
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1209);
    registry.bind("chat-server", this);
    System.out.println("RMI Server Handler is running");
  }

  @Override public void sendMessage(Message msg) throws IOException
  {
    chatManager.sendMessage(msg);
  }

  @Override public List<Message> getAllMessages() throws RemoteException
  {
    return chatManager.getAllMessages();
  }

  @Override public List<User> getFriends() throws RemoteException
  {
    ArrayList<ClientCallBack> clientList = new ArrayList<>(clients.keySet());
    ArrayList<User> friends = new ArrayList<>();
    for (ClientCallBack client : clientList)
    {
      friends.add(new User(client.getUsername()));
    }
    return friends;
  }

  //This was made for the exam
  @Override public void callBackDemo(ClientCallBack client) throws RemoteException
  {
    //Time-consuming calculations
    int sum = 0;
    for (int i = 0; i < 1000000; i++)
      for (int j = 0; j < 100000; j++)
        sum += i + j;

    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    client.callBackReply(sum);
  }


  @Override public void registerClient(ClientCallBack client) throws RemoteException
  {
    PropertyChangeListener listener = new PropertyChangeListener()
    {
      @Override
      public void propertyChange(PropertyChangeEvent evt)
      {
        try
        {
            client.update((Message) evt.getNewValue());
        } catch (Exception e) {
          //When this exception is handled, it takes a few seconds for the server to do everything
          e.printStackTrace();
          chatManager.removeListener("NewMessage", this);
          clients.remove(client);
        }
      }
    };
    clients.put(client, listener);
    chatManager.addListener("NewMessage", listener);
  }

  @Override public void unregisterClient(ClientCallBack client) throws RemoteException
  {
    PropertyChangeListener listener = clients.get(client);
    if(listener != null)
      chatManager.removeListener("NewMessage", listener);
    clients.remove(client);
  }
}
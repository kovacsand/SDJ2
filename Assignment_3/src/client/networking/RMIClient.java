package client.networking;

import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallBack
{
  private RMIServer server;
  private String username;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1209);
      server = (RMIServer) registry.lookup("chat-server");
      server.registerClient(this);
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void unregisterClient()
  {
    try
    {
      server.unregisterClient(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessage(String msg)
  {
    try
    {
      server.sendMessage(new Message(msg, username));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void allMessages()
  {
    try
    {
      messageHistory(server.getAllMessages());
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void setUsername(String username)
  {
    this.username = username;
  }

  @Override public void update(Message msg) throws RemoteException
  {
    support.firePropertyChange("NewMessage", null, msg);
  }

  @Override public void messageHistory(List<Message> messages)
      throws RemoteException
  {
    support.firePropertyChange("AllMessages", null, messages);
  }

  @Override public String getUsername()
  {
    return username;
  }

  //This was made for the exam
  @Override public void callBackReply(int sum) throws RemoteException
  {
    System.out.println(sum);
  }

  @Override public List<User> getFriends()
  {
    try
    {
      return server.getFriends();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  //This was made for the exam
  @Override public void callBackDemo()
  {
    try
    {
      server.callBackDemo(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(propertyName, listener);
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(propertyName, listener);
  }
}

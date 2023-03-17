package client.networking;

import shared.transferobjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  private ObjectOutputStream outToServer;
  private ObjectInputStream inFromServer;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 1209);
      outToServer = new ObjectOutputStream(socket.getOutputStream());
      inFromServer = new ObjectInputStream(socket.getInputStream());

      new Thread(() -> listenToServer(outToServer, inFromServer)).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
  {
    try
    {
      while (true)
      {
        Object object = inFromServer.readObject();
        if (object instanceof Message)
        {
          messageReceived((Message) object);
        }
        else if (object instanceof ArrayList)
        {
          ArrayList<Message> allMessages = (ArrayList<Message>) object;
          support.firePropertyChange("AllMessages", 0, allMessages);
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void messageReceived(Message msg)
  {
    support.firePropertyChange("NewMessage", 0, msg);
  }

  @Override public void sendMessage(String msg, String username)
  {
    try
    {
      outToServer.writeObject(new Message(msg, username));
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
      outToServer.writeObject(new Message("GetAllMessages", "ClientSystem"));
    }
    catch (IOException e)
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

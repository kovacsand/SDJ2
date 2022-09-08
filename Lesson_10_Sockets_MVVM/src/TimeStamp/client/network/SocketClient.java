package TimeStamp.client.network;

import TimeStamp.shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      Socket socket = new Socket("localhost", 1209);
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

      new Thread(() -> listenToServer(out, in)).start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream out, ObjectInputStream in)
  {
    try
    {
      out.writeObject(new Request("Listener", null));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    } while (true)
    {
      try
      {
        Request request = (Request) in.readObject();
        support.firePropertyChange(request.getType(), null, request.getArg());

      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      catch (ClassNotFoundException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
    System.out.println("support.getPropertyChangeListeners().length:" + support.getPropertyChangeListeners().length);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public String getLastUpdateTimeStamp()
  {
    try {
      Request response = request("01", "TimeStamp");
      return (String)response.getArg();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return "00";
  }

  @Override public int getNumberOfUpdates()
  {
    return 0;
  }

  @Override public void setTimeStamp(Date timeStamp)
  {

  }

  private Request request(String arg, String type) throws IOException, ClassNotFoundException {
    Socket socket = new Socket("localhost", 1209);
    ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
    outToServer.writeObject(new Request(type, arg));
    return (Request) inFromServer.readObject();
  }
}

package client.model;

import client.networking.Client;
import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.List;

public class ChatConverterManager implements ChatConverter
{
  private PropertyChangeSupport support;
  private Client client;

  public ChatConverterManager(Client client)
  {
    support = new PropertyChangeSupport(this);
    this.client = client;
    client.startClient();
    client.addListener("NewMessage", this::onNewMessage);
    client.addListener("AllMessages", this::onAllMessages);
  }

  private void onAllMessages(PropertyChangeEvent evt)
  {
    support.firePropertyChange(evt);
  }

  private void onNewMessage(PropertyChangeEvent evt)
  {
    newMessageReceived((Message) evt.getNewValue());
  }

  @Override public void sendMessage(String msg) throws IOException
  {
    client.sendMessage(msg);
  }

  @Override public void newMessageReceived(Message msg)
  {
    support.firePropertyChange("NewMessage", 0, msg.toString());
  }

  @Override public void getAllMessages()
  {
    client.allMessages();
  }

  @Override public void setUsername(String username)
  {
    client.setUsername(username);
  }

  @Override public void getUsername()
  {
    support.firePropertyChange("Username", 0, client.getUsername());
  }

  @Override public List<User> getFriends()
  {
    return client.getFriends();
  }

  @Override public void addListener(String propertyName, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(propertyName, listener);
  }

  @Override public void removeListener(String propertyName, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(propertyName, listener);
  }
}

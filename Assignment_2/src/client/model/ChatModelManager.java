package client.model;

import client.networking.Client;
import shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;

public class ChatModelManager implements ChatModel
{
  private PropertyChangeSupport support;
  private Client client;
  private String username;

  public ChatModelManager(Client client)
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
    messageReceived((Message) evt.getNewValue());
  }

  @Override public void sendMessage(String msg) throws IOException
  {
    client.sendMessage(msg, username);
  }

  @Override public void messageReceived(Message msg)
  {
    support.firePropertyChange("NewMessage", 0, msg.toString());
  }

  @Override public void getAllMessages()
  {
    client.allMessages();
  }

  @Override public void setUsername(String username)
  {
    this.username = username;
  }

  @Override public void getUsername()
  {
    support.firePropertyChange("Username", 0, username);
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

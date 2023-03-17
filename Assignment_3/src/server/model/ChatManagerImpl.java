package server.model;

import shared.transferobjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ChatManagerImpl implements ChatManager
{
  private final PropertyChangeSupport support;
  private List<Message> messages;

  public ChatManagerImpl()
  {
    support = new PropertyChangeSupport(this);
    messages = new ArrayList<>();
  }

  @Override public void sendMessage(Message msg)
  {
    messages.add(msg);
    support.firePropertyChange("NewMessage", null, msg);
  }

  @Override public List<Message> getAllMessages()
  {
    return messages;
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

package client.views.chat;

import client.model.ChatConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;

public class ChatViewModel implements PropertyChangeListener
{
  private ChatConverter model;

  private StringProperty username;
  private StringProperty messages;

  public ChatViewModel(ChatConverter model)
  {
    this.model = model;
    model.addListener("NewMessage", this);
    model.addListener("AllMessages", this);
    model.addListener("Username", this);
    username = new SimpleStringProperty();
    messages = new SimpleStringProperty();
  }

  public void sendMessage(String msg) throws IOException
  {
    model.sendMessage(msg);
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty messagesProperty()
  {
    return messages;
  }

  public void loadMessages()
  {
    model.getUsername();
    model.getAllMessages();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    switch (evt.getPropertyName())
    {
      case "Username":
        username.setValue((String) evt.getNewValue());
        break;
      case "NewMessage":
        String newMessage = (String) evt.getNewValue();
        messages.setValue(messages.getValue() + newMessage + "\n");
        break;
      case "AllMessages":
        List<Message> allMessages = (List<Message>) evt.getNewValue();
        messages.setValue("");
        for (Message message : allMessages)
          messages.setValue(messages.getValue() + message.toString() + "\n");
        break;
    }
  }
}

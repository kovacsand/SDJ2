package client.views.name;

import client.model.ChatModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NameViewModel implements PropertyChangeListener
{
  private ChatModel model;
  private StringProperty username;

  public NameViewModel(ChatModel model)
  {
    this.model = model;
    username = new SimpleStringProperty();
    model.addListener("Username", this);
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public void setUsername()
  {
    model.setUsername(username.getValue());
  }

  public void getUsername()
  {
    model.getUsername();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    username.setValue((String) evt.getNewValue());
  }
}

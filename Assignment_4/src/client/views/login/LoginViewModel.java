package client.views.login;

import client.model.ChatConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginViewModel implements PropertyChangeListener
{
  private ChatConverter model;
  private StringProperty username;

  public LoginViewModel(ChatConverter model)
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

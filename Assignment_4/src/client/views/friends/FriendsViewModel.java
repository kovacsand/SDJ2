package client.views.friends;

import client.model.ChatConverter;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferobjects.User;

import java.util.List;

public class FriendsViewModel
{
  private ChatConverter model;

  private ObservableList<User> friends;
  private StringProperty noFriends;

  public FriendsViewModel(ChatConverter model)
  {
    this.model = model;
    noFriends = new SimpleStringProperty();
  }

  public void loadFriends()
  {
    List<User> friendsList = model.getFriends();
    friends = FXCollections.observableArrayList(friendsList);
    Platform.runLater(() -> noFriends.setValue("Friends online: " + friendsList.size()));
  }

   public ObservableList<User> getFriends()
  {
    return friends;
  }

  public StringProperty noFriendsProperty()
  {
    return noFriends;
  }
}

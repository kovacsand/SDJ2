package client.model;

import shared.transferobjects.Message;
import shared.transferobjects.User;
import shared.util.Subject;

import java.io.IOException;
import java.util.List;

public interface ChatConverter extends Subject
{
  //I'm using observer pattern, because it might take a long time for the server to process everything

  void sendMessage(String msg) throws IOException;

  void newMessageReceived(Message msg);

  void getAllMessages();

  void setUsername(String username);

  void getUsername();

  List<User> getFriends();
}

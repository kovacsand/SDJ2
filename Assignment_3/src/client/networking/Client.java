package client.networking;

import shared.transferobjects.User;
import shared.util.Subject;

import java.util.List;

public interface Client extends Subject
{
  void startClient();

  void unregisterClient();

  void sendMessage(String msg);

  void allMessages();

  void setUsername(String username);

  String getUsername();

  List<User> getFriends();

  //This was made for the exam
  void callBackDemo();
}

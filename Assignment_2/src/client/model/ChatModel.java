package client.model;

import shared.transferobjects.Message;
import shared.util.Subject;

import java.io.IOException;

public interface ChatModel extends Subject
{
  void sendMessage(String msg) throws IOException;

  void messageReceived(Message msg);

  void getAllMessages();

  void setUsername(String username);

  void getUsername();
}

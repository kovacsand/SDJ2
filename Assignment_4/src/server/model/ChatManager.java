package server.model;

import shared.transferobjects.Message;
import shared.util.Subject;

import java.util.List;

public interface ChatManager extends Subject
{
  void sendMessage(Message msg);

  List<Message> getAllMessages();
}

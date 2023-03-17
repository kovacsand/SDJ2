package client.networking;

import shared.util.Subject;

public interface Client extends Subject
{
  void startClient();

  void sendMessage(String msg, String username);

  void allMessages();
}

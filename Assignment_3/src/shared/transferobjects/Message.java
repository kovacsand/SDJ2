package shared.transferobjects;

import java.io.Serializable;

public class Message implements Serializable
{
  private final String msg;
  private final String sender;

  public Message(String msg, String sender)
  {
    this.msg = msg;
    this.sender = sender;
  }

  public String getMsg()
  {
    return msg;
  }

  public String toString()
  {
    return sender + ": " + msg;
  }
}

package Chat.transferobjects;

import java.io.Serializable;

public class Message implements Serializable
{
  private String msg;
  private String sender;

  public Message(String msg, String sender)
  {
    this.msg = msg;
    this.sender = sender;
  }

  public String getMsg()
  {
    return msg;
  }

  public String getSender()
  {
    return sender;
  }

  public void setSender(String sender)
  {
    this.sender = sender;
  }

  public String toString()
  {
    return sender + ": " + msg;
  }
}

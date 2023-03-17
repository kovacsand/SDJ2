package Ex_11_5.transferObjects;

import java.io.Serializable;

public class Message implements Serializable

{
  private String msg;
  private int id;

  public Message(String msg, int id)
  {
    this.msg = msg;
    this.id = id;
  }

  public String getMsg()
  {
    return msg;
  }

  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }
  public String toString()
  {
    return "Id:" + id + ": " +msg;
  }
}

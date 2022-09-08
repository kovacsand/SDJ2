package MultipleClientConnects.transferobjects;

import java.io.Serializable;

public class Request implements Serializable
{
  private String arg;
  private String requestType;

  public Request(String arg, String requestType)
  {
    this.arg = arg;
    this.requestType = requestType;
  }

  public String getArg()
  {
    return arg;
  }

  public String getRequestType()
  {
    return requestType;
  }
}

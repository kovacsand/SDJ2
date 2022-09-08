package Increment;

import java.io.IOException;

public class RunClient
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException, InterruptedException
  {
    Client client = new Client();
    client.start();
  }
}

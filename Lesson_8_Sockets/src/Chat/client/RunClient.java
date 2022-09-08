package Chat.client;

import Chat.client.networking.SocketClient;

import java.io.IOException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args) throws IOException
  {
    SocketClient client = new SocketClient();
    client.start();

    while(true){
      client.sendMessage(new Scanner(System.in).nextLine());
    }
  }
}

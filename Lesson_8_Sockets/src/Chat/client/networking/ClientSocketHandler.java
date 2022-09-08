package Chat.client.networking;

import Chat.transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private SocketClient socketClient;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private String username;

  public ClientSocketHandler(Socket socket, SocketClient socketClient) throws IOException
  {
    this.socket = socket;
    this.socketClient = socketClient;
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  public void sendMessage(String msg) throws IOException
  {
    out.writeObject(new Message(msg, username));
  }

  @Override public void run()
  {
    try
    {
      String message = (String) in.readObject();
      username = message.split(" ")[1];
      System.out.println(message);

      while (true)
      {
        socketClient.messageReceived((Message) in.readObject());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
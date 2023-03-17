package MultipleClientConnects.client;

import MultipleClientConnects.transferobjects.Message;
import MultipleClientConnects.transferobjects.Request;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient
{
  public void start()
  {
    try (
        Socket socket = new Socket("127.0.0.1", 1235);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
    ) {

      Message message = (Message) in.readObject();
      System.out.println(message.getMsg());
      String name = new Scanner(System.in).nextLine();
      out.writeObject(new Message(name));
      message = (Message) in.readObject();
      System.out.println(message.getMsg());

      String string = "";
      do
      {
          message = ((Message) in.readObject());
          System.out.println(message.getMsg());
          String requestType = new Scanner(System.in).nextLine();
          string = new Scanner(System.in).nextLine();
          out.writeObject(new Request(string, requestType));
          message = ((Message) in.readObject());
          System.out.println(message.getMsg());
      } while (!string.equals("exit") && !string.equals("stop"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void sendMessage(String msg)
  {

  }
}

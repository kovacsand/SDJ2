package MultipleClientConnects.server;

import MultipleClientConnects.transferobjects.Message;
import MultipleClientConnects.transferobjects.Request;

import java.io.*;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private StringModel sm;

  public ServerSocketHandler(Socket socket, StringModel sm)
  {
    this.socket = socket;
    this.sm = sm;
  }

  @Override public void run()
  {
    try
    {
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
      System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());

      out.writeObject(new Message("Hello from server. Write your name"));
      String nameFromClient = ((Message) in.readObject()).getMsg();
      out.writeObject(new Message("Hello " + nameFromClient));

      String stringFromClient;
      do
      {
        out.writeObject(new Message("Please give me a string to change. First write uppercase or lowercase and then press enter, then write the message"));

        Request requestFromClient = (Request) in.readObject();
        stringFromClient = requestFromClient.getArg();
        String typeFromClient = requestFromClient.getRequestType();
        if (typeFromClient.equals("lowercase"))
          stringFromClient = sm.toLowerCase(stringFromClient);
        if (typeFromClient.equals("uppercase"))
          stringFromClient = sm.toUpperCase(stringFromClient);

        out.writeObject(new Message(stringFromClient));
      } while (!stringFromClient.equalsIgnoreCase("exit") && !stringFromClient.equalsIgnoreCase("stop"));
    } catch (Exception e) { e.printStackTrace();}
  }
}

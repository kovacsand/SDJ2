import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain
{
  public static void main(String[] args)
      throws NotBoundException, RemoteException
  {
    Client client = new Client();
    client.sendText("Hello");
    client.sendText("How are you?");
    client.sendText("Goodbye");
  }
}

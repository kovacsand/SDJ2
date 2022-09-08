import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
  private TextServer server;

  public Client() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1209);
    server = (TextServer) registry.lookup("text-server");
  }

  public void sendText(String text) throws RemoteException
  {
    server.printText(text);
  }
}

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1209);
    RMITextServer server = new RMITextServer();
    registry.bind("text-server",server);
    System.out.println("Server is running");
  }
}

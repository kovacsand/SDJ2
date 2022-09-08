import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITextServer implements TextServer
{
  public RMITextServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 1209);
  }

  @Override
  public void printText(String text) throws RemoteException
  {
    System.out.println(text);
  }
}

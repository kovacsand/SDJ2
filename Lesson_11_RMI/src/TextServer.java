import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextServer extends Remote
{
  void printText(String text) throws RemoteException;
}

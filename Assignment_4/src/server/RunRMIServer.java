package server;

import server.model.ChatManagerImpl;
import server.networking.RMIServerImpl;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunRMIServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RMIServerImpl server = new RMIServerImpl(new ChatManagerImpl());
    server.startServer();
  }
}

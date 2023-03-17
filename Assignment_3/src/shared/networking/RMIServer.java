package shared.networking;

import shared.transferobjects.Message;
import shared.transferobjects.User;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  void sendMessage(Message msg) throws IOException;

  List<Message> getAllMessages() throws RemoteException;

  List<User> getFriends() throws RemoteException;

  //This was made for the exam
  void callBackDemo(ClientCallBack client) throws RemoteException;

  void registerClient(ClientCallBack client) throws RemoteException;

  void unregisterClient(ClientCallBack client) throws RemoteException;
}

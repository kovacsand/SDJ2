package shared.networking;

import shared.transferobjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ClientCallBack extends Remote
{
  void update(Message msg) throws RemoteException;

  void messageHistory(List<Message> messages) throws RemoteException;

  String getUsername() throws RemoteException;

  //This was made for the exam
  void callBackReply(int sum) throws RemoteException;
}

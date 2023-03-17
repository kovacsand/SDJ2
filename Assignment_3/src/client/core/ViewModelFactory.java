package client.core;

import client.views.chat.ChatViewModel;
import client.views.friends.FriendsViewModel;
import client.views.login.LoginViewModel;

public class ViewModelFactory
{
  private ChatViewModel chatVM;
  private LoginViewModel loginVM;
  private FriendsViewModel friendsVM;

  public ViewModelFactory(ModelFactory mf)
  {
    chatVM = new ChatViewModel(mf.getModel());
    loginVM = new LoginViewModel(mf.getModel());
    friendsVM = new FriendsViewModel(mf.getModel());
  }

  public ChatViewModel getChatVM()
  {
    return chatVM;
  }

  public LoginViewModel getLoginVM()
  {
    return loginVM;
  }

  public FriendsViewModel getFriendsVM()
  {
    return friendsVM;
  }
}

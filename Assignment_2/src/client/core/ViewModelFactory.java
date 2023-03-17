package client.core;

import client.views.chat.ChatViewModel;
import client.views.name.NameViewModel;

public class ViewModelFactory
{
  private ChatViewModel chatVM;
  private NameViewModel nameVM;

  public ViewModelFactory(ModelFactory mf)
  {
    chatVM = new ChatViewModel(mf.getModel());
    nameVM = new NameViewModel(mf.getModel());
  }

  public ChatViewModel getChatVM()
  {
    return chatVM;
  }

  public NameViewModel getNameVM()
  {
    return nameVM;
  }
}

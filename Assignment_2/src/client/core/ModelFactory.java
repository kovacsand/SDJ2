package client.core;

import client.model.ChatModel;
import client.model.ChatModelManager;

public class ModelFactory
{
  private ChatModel model;
  private ClientFactory cf;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  public ChatModel getModel()
  {
    if (model == null)
      model = new ChatModelManager(cf.getClient());
    return model;
  }
}

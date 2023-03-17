package client.core;

import client.model.ChatConverter;
import client.model.ChatConverterManager;

public class ModelFactory
{
  private ChatConverter model;
  private final ClientFactory cf;

  public ModelFactory(ClientFactory cf)
  {
    this.cf = cf;
  }

  public ChatConverter getModel()
  {
    if (model == null)
      model = new ChatConverterManager(cf.getClient());
    return model;
  }
}

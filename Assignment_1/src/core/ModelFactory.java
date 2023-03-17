package core;

import mediator.TemperatureModel;
import mediator.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel model;

  public TemperatureModel getModel()
  {
    if (model == null)
      model = new TemperatureModelManager();
    return model;
  }
}

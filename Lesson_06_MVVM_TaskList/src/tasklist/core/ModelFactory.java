package tasklist.core;

import tasklist.model.TaskModel;
import tasklist.model.TaskModelManager;

public class ModelFactory
{
  private TaskModel model;

  public TaskModel getModel()
  {
    if (model == null)
      model = new TaskModelManager();
    return model;
  }
}

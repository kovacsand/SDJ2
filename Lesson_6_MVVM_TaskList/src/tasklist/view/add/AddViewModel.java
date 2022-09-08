package tasklist.view.add;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import tasklist.model.TaskModel;
import tasklist.model.TaskModelManager;

public class AddViewModel
{
  private StringProperty creator;
  private StringProperty description;

  private TaskModel model;

  public AddViewModel(TaskModel model)
  {
    this.model = model;
    creator = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  public void addTask()
  {
    if (!creator.getValue().equals("") && !description.getValue().equals(""))
    {
      model.addNewTask(creator.getValue(), description.getValue());
      creator.setValue("");
      description.setValue("");
    }
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }
}

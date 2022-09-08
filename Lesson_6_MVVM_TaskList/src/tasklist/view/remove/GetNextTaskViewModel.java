package tasklist.view.remove;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tasklist.model.Task;
import tasklist.model.TaskModel;

public class GetNextTaskViewModel
{
  private StringProperty description;
  private StringProperty creator;
  private StringProperty date;

  private TaskModel model;

  public GetNextTaskViewModel(TaskModel model)
  {
    this.model = model;
    description = new SimpleStringProperty();
    creator = new SimpleStringProperty();
    date = new SimpleStringProperty();
  }

  public void getNextTask()
  {
    Task nextTask = model.getNextTask();
    description.setValue(nextTask.getDescription());
    creator.setValue(nextTask.getCreator());
    date.setValue(nextTask.getDateCreated());
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty dateProperty()
  {
    return date;
  }
}

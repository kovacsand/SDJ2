package tasklist.view.all;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasklist.model.Task;
import tasklist.model.TaskModel;

import java.beans.PropertyChangeEvent;

public class TaskListViewModel
{
  private ObservableList<Task> items;
  private TaskModel model;

  public TaskListViewModel(TaskModel model)
  {
    this.model = model;
    items = FXCollections.observableArrayList();
    model.addListener("TaskAdded", evt -> listModified(evt));
    model.addListener("TaskRemoved", evt -> items.remove(evt.getNewValue()));
  }

  private void listModified(PropertyChangeEvent evt)
  {
    items.add((Task) evt.getNewValue());
  }

  public ObservableList<Task> getItems()
  {
    return items;
  }
}

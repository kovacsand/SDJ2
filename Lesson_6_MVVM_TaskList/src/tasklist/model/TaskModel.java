package tasklist.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface TaskModel
{
  void addNewTask(String creator, String description);

  Task getNextTask();

  void addListener(String eventName, PropertyChangeListener listener);
}

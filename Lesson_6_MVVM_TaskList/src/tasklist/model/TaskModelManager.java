package tasklist.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> tasks;
  private PropertyChangeSupport support;

  public TaskModelManager()
  {
    tasks = new ArrayList<>();
    support = new PropertyChangeSupport(this);
  }

  private String calcTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    return sdfDate.format(now);
  }

  @Override public void addNewTask(String owner, String description)
  {
    Task newTask = new Task(owner, description, calcTimeStamp());
    tasks.add(newTask);
    support.firePropertyChange("TaskAdded", null, newTask);
  }

  @Override public Task getNextTask()
  {
    Task nextTask = tasks.remove(0);
    support.firePropertyChange("TaskRemoved", null, nextTask);
    return nextTask;
  }

  @Override public void addListener(String eventName, PropertyChangeListener listener)
  {
    if (eventName == null || eventName.equals(""))
      support.addPropertyChangeListener(listener);
    else
      support.addPropertyChangeListener(eventName, listener);
  }
}

package tasklist.core;

import tasklist.view.add.AddViewModel;
import tasklist.view.all.TaskListViewModel;
import tasklist.view.remove.GetNextTaskViewModel;

public class ViewModelFactory
{
  private TaskListViewModel taskListVM;
  private AddViewModel addVM;
  private GetNextTaskViewModel getNextTaskVM;

  public ViewModelFactory(ModelFactory mf)
  {
    taskListVM = new TaskListViewModel(mf.getModel());
    addVM = new AddViewModel(mf.getModel());
    getNextTaskVM = new GetNextTaskViewModel(mf.getModel());
  }

  public TaskListViewModel getTaskListVM()
  {
    return taskListVM;
  }

  public AddViewModel getAddVM()
  {
    return addVM;
  }

  public GetNextTaskViewModel getNextTaskVM()
  {
    return getNextTaskVM;
  }
}

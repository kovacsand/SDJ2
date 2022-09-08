package tasklist.view.all;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;
import tasklist.model.Task;

public class TaskListViewController
{
  @FXML private TableView<Task> tableView;
  @FXML private TableColumn<String, Task> creatorColumn;
  @FXML private TableColumn<String, Task> descriptionColumn;
  @FXML private TableColumn<String, Task> dateColumn;

  private TaskListViewModel vm;
  private ViewHandler vh;

  public void init(ViewModelFactory vmf, ViewHandler vh) {
    this.vm = vmf.getTaskListVM();
    this.vh = vh;
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
    tableView.setItems(vm.getItems());
  }

  public void onAddButton()
  {
    vh.openAddView();
  }

  public void onNextTaskButton()
  {
    vh.openNextTaskView();
  }
}

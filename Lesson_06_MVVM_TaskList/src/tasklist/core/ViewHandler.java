package tasklist.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tasklist.view.add.AddViewController;
import tasklist.view.all.TaskListViewController;
import tasklist.view.all.TaskListViewModel;
import tasklist.view.remove.GetNextTaskViewController;

import javax.script.ScriptContext;
import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(Stage stage, ViewModelFactory vmf)
  {
    this.stage = stage;
    this.vmf = vmf;
  }

  public void start()
  {
    openAllView();
  }

  public void openAllView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/all/TaskListView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    TaskListViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("All tasks");
    stage.setScene(scene);
    stage.show();
  }

  public void openAddView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/add/AddView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    AddViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("Add task");
    stage.setScene(scene);
    stage.show();
  }

  public void openNextTaskView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/remove/GetNextTaskView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    GetNextTaskViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("Get new task");
    stage.setScene(scene);
    stage.show();
  }
}

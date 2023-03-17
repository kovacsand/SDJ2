package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mediator.TemperatureModel;
import view.control.ControlViewController;
import view.temperatures.TemperaturesViewController;
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
    openTemperaturesView();
  }

  public void openTemperaturesView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/temperatures/TemperaturesView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    TemperaturesViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("Temperatures");
    stage.setScene(scene);
    stage.show();
  }

  public void openControlView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../view/control/ControlView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    ControlViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("Controls");
    stage.setScene(scene);
    stage.show();
  }
}

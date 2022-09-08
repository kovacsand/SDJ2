package uppercase.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uppercase.view.log.LogViewController;
import uppercase.view.uppercase.UppercaseViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene uppercaseScene;
  private Scene logScene;
  private ViewModelFactory vmf;

  public ViewHandler(Stage stage, ViewModelFactory vmf)
  {
    this.stage = stage;
    this.vmf = vmf;
  }

  public void start() throws IOException
  {
    openToView("Uppercase");
  }

  public void openToView(String viewAddress) throws IOException
  {
    Parent root = null;
    FXMLLoader loader = new FXMLLoader();
    if (viewAddress.equals("Uppercase"))
    {
      loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
      System.out.println(loader.getLocation());
      root = loader.load();
      UppercaseViewController view = loader.getController();
      view.init(this, vmf.getUppercaseVM());
      stage.setTitle("Converter");
      uppercaseScene = new Scene(root);
      stage.setScene(uppercaseScene);
    }
    else if (viewAddress.equals("Log"))
    {
      loader.setLocation(getClass().getResource("../view/log/LogView.fxml"));
      root = loader.load();
      LogViewController view = loader.getController();
      view.init(this, vmf.getLogVM());
      stage.setTitle("Logs");
      logScene = new Scene(root);
      stage.setScene(logScene);
    }
    stage.show();
  }
}

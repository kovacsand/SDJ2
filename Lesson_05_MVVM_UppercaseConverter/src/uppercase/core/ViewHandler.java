package uppercase.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uppercase.view.uppercase.UppercaseViewController;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene uppercaseScene;
  private ViewModelFactory vmf;

  public ViewHandler(Stage stage, uppercase.core.ViewModelFactory vmf)
  {
    this.stage = stage;
    this.vmf = vmf;
  }

  public void start() throws IOException
  {
    openToUppercase();
  }

  public void openToUppercase() throws IOException
  {
    if (uppercaseScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
        System.out.println(loader.getLocation());
        Parent root = loader.load();
        UppercaseViewController view = loader.getController();
        view.init(vmf.getUppercaseVM());
        stage.setTitle("Converter");
        uppercaseScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    stage.setScene(uppercaseScene);
    stage.show();
  }
}

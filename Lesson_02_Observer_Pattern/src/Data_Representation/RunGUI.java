package Data_Representation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunGUI extends Application
{
  public void start(Stage stage) throws Exception
  {
    stage.setTitle("Data Modelling");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("Charts.fxml"));
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.show();
  }
}

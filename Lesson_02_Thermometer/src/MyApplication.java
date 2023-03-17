import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    Thread temp1 = new Thread(new Thermometer(model, "1", 20, 0));
    Thread temp2 = new Thread(new Thermometer(model, "2", 15, 3));

    temp1.start();
    temp2.start();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}

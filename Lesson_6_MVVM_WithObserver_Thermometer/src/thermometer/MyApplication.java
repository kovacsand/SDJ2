package thermometer;

import javafx.application.Application;
import javafx.stage.Stage;
import thermometer.temperature.mediator.TemperatureModel;
import thermometer.temperature.mediator.TemperatureModelManager;
import thermometer.temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);


    Thread t1 = new Thread(new Thermometer("t1", 15, 1, model));
    Thread t2 = new Thread(new Thermometer("t2", 15, 7, model));
    t1.start();
    t2.start();


  }
}

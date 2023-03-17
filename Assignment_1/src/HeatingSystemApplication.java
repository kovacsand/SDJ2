import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;

public class HeatingSystemApplication extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(stage, vmf);
    vh.start();

    mf.getModel().turnUpRadiator();
    mf.getModel().turnUpRadiator();
    mf.getModel().turnUpRadiator();
  }
}

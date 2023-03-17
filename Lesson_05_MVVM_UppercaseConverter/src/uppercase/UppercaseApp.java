package uppercase;

import javafx.application.Application;
import javafx.stage.Stage;
import uppercase.core.ModelFactory;
import uppercase.core.ViewHandler;
import uppercase.core.ViewModelFactory;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();
  }
}

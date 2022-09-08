package Ex_11_5.Client;

import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application
{
  private ClientMain1 client = new ClientMain1();

  @Override public void start(Stage stage) throws Exception
  {
    client.runClient();
    ViewHandler vh = new ViewHandler(client);
    vh.start();

  }
}

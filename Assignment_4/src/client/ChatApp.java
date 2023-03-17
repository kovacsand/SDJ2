package client;

import client.core.ClientFactory;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ChatApp extends Application
{
  private ClientFactory cf;
  private Stage stage;

  @Override public void start(Stage stage)
  {
    cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(stage, vmf);
    vh.start();
    this.stage = stage;
    this.stage.setOnCloseRequest((event) -> {
      cf.getClient().unregisterClient();
      Platform.exit();
      System.exit(0);
    });
  }

  @Override public void stop() throws Exception
  {
    super.stop();
    System.out.println("Client stopped");
    cf.getClient().unregisterClient();
  }
}
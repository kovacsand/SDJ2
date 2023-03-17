package client.core;

import client.views.chat.ChatViewController;
import client.views.name.NameViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

  public void start() {
    openNameView();
  }

  public void openChatView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/chat/ChatView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    ChatViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("Chat");
    stage.setScene(scene);
    stage.show();
  }

  public void openNameView()
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("../views/name/NameView.fxml"));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    NameViewController view = loader.getController();
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setTitle("Name");
    stage.setScene(scene);
    stage.show();
  }
}

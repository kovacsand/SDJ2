package client.core;

import client.views.ViewController;
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
    openLoginView();
  }

  private void openView(String viewName)
  {
    FXMLLoader loader = new FXMLLoader();
    if (viewName.equals("Chat"))
      loader.setLocation(getClass().getResource("../views/chat/ChatView.fxml"));
    if (viewName.equals("Login"))
      loader.setLocation(getClass().getResource("../views/login/LoginView.fxml"));
    if (viewName.equals("Friends"))
      loader.setLocation(getClass().getResource("../views/friends/FriendsView.fxml"));

    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    ViewController view = loader.getController();
    stage.setTitle(viewName);
    view.init(vmf, this);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openChatView()
  {
    openView("Chat");
  }

  public void openLoginView()
  {
    openView("Login");
  }

  public void openFriendsView()
  {
    openView("Friends");
  }
}

package Ex_11_5.Client;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class ViewHandler
{
  private Scene chatScene;
  private Stage stage;
  private ClientMain1 client;

  public ViewHandler(ClientMain1 client)
  {
    this.client=client;
  }

  public void start()
  {
    stage = new Stage();
    openView();

  }

  public void openView()
  {
    if(chatScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Ex_11_5/Client/chat.fxml"));
        Parent root = loader.load();

        chatController ctrl = loader.getController();
        ctrl.init(client);
        client.setController(ctrl);

        stage.setTitle("Chat");
        chatScene = new Scene(root);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(chatScene);
    stage.show();

  }


}


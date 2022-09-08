package Ex_11_5.Client;

import Ex_11_5.transferObjects.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class chatController
{

  @FXML
  private TextField messageTextField;
  @FXML
  private Button sendText;
  @FXML
  private TextArea textArea;

  private ClientMain1 client;


  public void init(ClientMain1 client)
  {
    this.client = client;
  }

  @FXML
  public void sendText(ActionEvent actionEvent)
  {
    Message message = new Message(messageTextField.getText(), client.getId());

    client.sendMessage(message);
  }
  public void updateMessages()
  {
    textArea.clear();
    String allMessages = client.getList();
    textArea.appendText(allMessages);
  }
}

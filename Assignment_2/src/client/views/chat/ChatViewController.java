package client.views.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.io.IOException;

public class ChatViewController
{
  private ChatViewModel viewModel;
  private ViewHandler vh;

  @FXML private Label usernameLabel;
  @FXML private TextField messageField;
  @FXML private TextArea messagesArea;

  public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vh = vh;
    this.viewModel = vmf.getChatVM();

    messagesArea.setEditable(false);
    messageField.setPromptText("Write message here");

    viewModel.usernameProperty().bindBidirectional(usernameLabel.textProperty());
    viewModel.messagesProperty().bindBidirectional(messagesArea.textProperty());

    viewModel.loadMessages();

    usernameLabel.setText("Welcome back, " + usernameLabel.getText() + "!");

    messageField.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode().equals(KeyCode.ENTER))
      {
        try
        {
          onSendButton();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  @FXML
  private void onSendButton() throws IOException
  {
    String message = messageField.getText();
    messageField.setText("");
    viewModel.sendMessage(message);
  }

  @FXML
  private void onChangeButton()
  {
    vh.openNameView();
  }
}

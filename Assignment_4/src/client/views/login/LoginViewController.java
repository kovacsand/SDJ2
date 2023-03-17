package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class LoginViewController implements ViewController
{
  private LoginViewModel viewModel;
  private ViewHandler vh;

  @FXML private TextField usernameField;

  public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vh = vh;
    this.viewModel = vmf.getLoginVM();
    viewModel.usernameProperty().bindBidirectional(usernameField.textProperty());

    viewModel.getUsername();

    usernameField.setOnKeyPressed(keyEvent -> {
      if (keyEvent.getCode().equals(KeyCode.ENTER))
      {
        onSaveButton();
      }
    });
  }

  @FXML
  private void onSaveButton()
  {
    viewModel.setUsername();
    vh.openChatView();
  }
}

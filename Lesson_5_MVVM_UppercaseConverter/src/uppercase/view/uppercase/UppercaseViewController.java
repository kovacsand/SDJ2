package uppercase.view.uppercase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;

  private UppercaseViewModel viewModel;

  public void init(UppercaseViewModel viewModel)
  {
    this.viewModel = viewModel;
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
    errorLabel.textProperty().bind(viewModel.errorProperty());
  }

  public void onSubmitButton()
  {
    viewModel.convert();
  }

  public void onEnter()
  {
  }
}

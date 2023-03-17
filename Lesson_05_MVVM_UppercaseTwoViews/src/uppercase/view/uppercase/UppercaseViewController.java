package uppercase.view.uppercase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uppercase.core.ViewHandler;

import java.io.IOException;

public class UppercaseViewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;

  private ViewHandler viewHandler;
  private UppercaseViewModel viewModel;

  public void init(ViewHandler viewHandler, UppercaseViewModel viewModel)
  {
    this.viewHandler = viewHandler;
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
    onSubmitButton();
  }

  public void onShow() throws IOException
  {
    viewModel.clear();
    viewHandler.openToView("Log");
  }
}

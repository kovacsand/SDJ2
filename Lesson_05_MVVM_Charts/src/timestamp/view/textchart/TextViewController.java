package timestamp.view.textchart;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import timestamp.viewmodel.textrepresentation.TextViewModel;

public class TextViewController
{
  @FXML private Label eventLabel;
  @FXML private TextField xTextField;
  @FXML private TextField yTextField;
  @FXML private TextField zTextField;

  private TextViewModel vm;

  public void init(TextViewModel vm)
  {
    this.vm = vm;
    eventLabel.textProperty().bind(vm.updateProperty());
    xTextField.textProperty().bindBidirectional(vm.xProperty());
    yTextField.textProperty().bindBidirectional(vm.yProperty());
    zTextField.textProperty().bindBidirectional(vm.zProperty());
  }

  @FXML public void onUpdateButton()
  {
    vm.updateTextFields();
  }

  @FXML public void onSaveButton()
  {
    vm.saveChanges();
  }
}

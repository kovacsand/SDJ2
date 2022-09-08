package tasklist.view.add;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;

public class AddViewController
{
  @FXML private TextField creatorTextField;
  @FXML private TextField descriptionTextField;

  private AddViewModel vm;
  private ViewHandler vh;

  public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vm = vmf.getAddVM();
    this.vh = vh;
    vm.creatorProperty().bindBidirectional(creatorTextField.textProperty());
    vm.descriptionProperty().bindBidirectional(descriptionTextField.textProperty());
  }

  public void onAddButton()
  {
    vm.addTask();
  }

  public void onBackButton()
  {
    vh.openAllView();
  }
}

package tasklist.view.remove;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import tasklist.core.ViewHandler;
import tasklist.core.ViewModelFactory;

public class GetNextTaskViewController
{
  @FXML private Label descriptionLabel;
  @FXML private Label creatorLabel;
  @FXML private Label dateLabel;

  private GetNextTaskViewModel vm;
  private ViewHandler vh;

  public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vm = vmf.getNextTaskVM();
    this.vh = vh;
    descriptionLabel.textProperty().bind(vm.descriptionProperty());
    creatorLabel.textProperty().bind(vm.creatorProperty());
    dateLabel.textProperty().bind(vm.dateProperty());
  }

  public void onGetTaskButton()
  {
    vm.getNextTask();
  }

  public void onBackButton()
  {
    vh.openAllView();
  }
}

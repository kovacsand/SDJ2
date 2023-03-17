package view.control;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControlViewController
{
  @FXML private Label heaterLabel;
  @FXML private TextField lowTextField;
  @FXML private TextField highTextField;

  private ControlViewModel vm;
  private ViewHandler vh;

  public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vm = vmf.getControlVM();
    this.vh = vh;

    vm.heaterProperty().bindBidirectional(heaterLabel.textProperty());
    vm.lowProperty().bindBidirectional(lowTextField.textProperty());
    vm.highProperty().bindBidirectional(highTextField.textProperty());
    vm.init();
  }

  public void onSaveButton()
  {
    vm.saveCritical();
  }

  public void onTurnDownButton()
  {
    vm.turnDownRadiator();
  }

  public void onTurnUpButton()
  {
    vm.turnUpRadiator();
  }

  public void onBackButton()
  {
    vh.openTemperaturesView();
  }
}

package view.temperatures;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TemperaturesViewController
{
  @FXML private Label t1Label;
  @FXML private Label t2Label;
  @FXML private Label heaterLabel;
  @FXML private Label warningsLabel;

  private TemperaturesViewModel vm;
  private ViewHandler vh;

  public void init(ViewModelFactory vmf, ViewHandler vh)
  {
    this.vm =vmf.getTemperaturesVM();
    this.vh = vh;

    vm.thermometer1Property().bindBidirectional(t1Label.textProperty());
    vm.thermometer2Property().bindBidirectional(t2Label.textProperty());
    vm.heaterProperty().bindBidirectional(heaterLabel.textProperty());
    vm.warningsProperty().bindBidirectional(warningsLabel.textProperty());

    vm.init();
  }

  public void onControlButton()
  {
    vh.openControlView();
  }
}

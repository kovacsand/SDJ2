package view.temperatures;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperaturesViewModel implements PropertyChangeListener
{
  private TemperatureModel model;

  private StringProperty thermometer1;
  private StringProperty thermometer2;
  private StringProperty heater;
  private StringProperty warnings;

  public TemperaturesViewModel(TemperatureModel model)
  {
    this.model = model;
    model.addListener(null, this);
    thermometer1 = new SimpleStringProperty();
    thermometer2 = new SimpleStringProperty();
    heater = new SimpleStringProperty();
    warnings = new SimpleStringProperty();
  }

  public void init()
  {
    Platform.runLater(() -> {
      heaterProperty().setValue(
          "Radiator power level: " + model.getRadiatorPowerState());
      if (model.getLastInsertedTemperature("t2") != null
          && model.getLastInsertedTemperature("t1") != null)
      {
        thermometer1.setValue(
            "Thermometer 1:\n" + model.getLastInsertedTemperature("t1")
                .toString());
        thermometer2.setValue(
            "Thermometer 2:\n" + model.getLastInsertedTemperature("t2")
                .toString());
      }
      checkCritical();
    });
  }

  private void checkCritical()
  {
    if (model.getLastInsertedTemperature("t2") != null
        && model.getLastInsertedTemperature("t1") != null)
    {
      String warningsString = "Warnings: ";
      if (model.getLastInsertedTemperature("t1").getValue() < model.getCriticalLow())
        warningsString += "t1 is too low ";
      else if ((model.getLastInsertedTemperature("t1").getValue() > model.getCriticalHigh()))
        warningsString += "t1 is too high ";
      if (model.getLastInsertedTemperature("t2").getValue() < model.getCriticalLow())
        warningsString += "t2 is too low ";
      else if ((model.getLastInsertedTemperature("t2").getValue() > model.getCriticalHigh()))
        warningsString += "t2 is too high ";
      if (warningsString.equals("Warnings: "))
        warnings.setValue("Warnings: none");
      else
        warnings.setValue(warningsString);
    }
  }

  public StringProperty thermometer1Property()
  {
    return thermometer1;
  }

  public StringProperty thermometer2Property()
  {
    return thermometer2;
  }

  public StringProperty heaterProperty()
  {
    return heater;
  }

  public StringProperty warningsProperty()
  {
    return warnings;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> heaterProperty().setValue(
        "Radiator power level: " + model.getRadiatorPowerState()));
    if ( evt.getNewValue().toString().contains("t1"))
      Platform.runLater(() -> thermometer1.setValue(
          "Thermometer 1:\n" + evt.getNewValue().toString()));
    if (evt.getNewValue().toString().contains("t2"))
      Platform.runLater(() -> thermometer2.setValue(
          "Thermometer 2:\n" + evt.getNewValue().toString()));
    if (evt.getOldValue() != null && evt.getOldValue().toString()
        .contains("radiator"))
      Platform.runLater(() -> heater.setValue(
          "Radiator power level: " + evt.getNewValue().toString()));
    Platform.runLater(this::checkCritical);
  }
}

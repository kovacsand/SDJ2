package view.control;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ControlViewModel implements PropertyChangeListener
{
  private TemperatureModel model;

  private StringProperty heater;
  private StringProperty low;
  private StringProperty high;

  public ControlViewModel(TemperatureModel model)
  {
    this.model = model;
    model.addListener(null, this);

    heater = new SimpleStringProperty();
    low = new SimpleStringProperty();
    high = new SimpleStringProperty();
  }

  public void init()
  {
    heater.setValue("Radiator power level: " + model.getRadiatorPowerState());
    low.setValue(model.getCriticalLow() + "");
    high.setValue(model.getCriticalHigh() + "");
  }

  public StringProperty heaterProperty()
  {
    return heater;
  }

  public StringProperty lowProperty()
  {
    return low;
  }

  public StringProperty highProperty()
  {
    return high;
  }

  public void saveCritical()
  {
    model.setCriticalLow(Double.parseDouble(low.getValue()));
    model.setCriticalHigh(Double.parseDouble(high.getValue()));
  }

  public void turnDownRadiator()
  {
    model.turnDownRadiator();
  }

  public void turnUpRadiator()
  {
    model.turnUpRadiator();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getOldValue() != null && evt.getOldValue().toString().contains("radiator"))
      Platform.runLater(() -> heater.setValue("Radiator power level: " + evt.getNewValue().toString()));
  }
}

package temperaturemvvm.view.temperature;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import temperature.mediator.TemperatureModel;

public class TemperatureViewModel
{
  private StringProperty temperature;
  private StringProperty id;
  private TemperatureModel model;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;
  }

  public void getLastTemp()
  {
    return ;
  }

  public void updateThermometerId()
  {
    //So this used to work with JDK 11 and JavaFX, but now it doesn't
//    String oldValue = filterLabel.getText();
//    if (oldValue.equals("All"))
//    {
//      oldValue = null;
//    }
//    id = filterField.getText();
//    if (id.isEmpty())
//    {
//      id = null;
//      filterLabel.setText("All");
//    }
//    else
//    {
//      filterLabel.setText(id.getValue());
//      if (id.getValue() == "2")
//        model.removeListener("1", this);
//      else
//        model.removeListener("2", this);
//      model.addListener(id.getValue(), this);
//    }
//    filterField.setText(null);
//    updateButtonPressed();
  }

  public StringProperty temperatureProperty()
  {
    return temperature;
  }

  public StringProperty idProperty()
  {
    return id;
  }
}

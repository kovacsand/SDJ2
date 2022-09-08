package timestamp.viewmodel.barchart;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import timestamp.model.DataModel;

public class BarChartViewModel
{
  private IntegerProperty x;
  private IntegerProperty y;
  private IntegerProperty z;

  private StringProperty updateTimeStamp;
  private DataModel model;

  public BarChartViewModel(DataModel model)
  {
    this.model = model;
    x = new SimpleIntegerProperty();
    y = new SimpleIntegerProperty();
    z = new SimpleIntegerProperty();
    updateTimeStamp = new SimpleStringProperty("Last update: ");
  }

  public void updateBarChart()
  {
    double[] vals = model.getDataValues();
    x.setValue(vals[0]);
    y.setValue(vals[1]);
    z.setValue(vals[2]);
    updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
  }

  public IntegerProperty xProperty()
  {
    return x;
  }
  public IntegerProperty yProperty()
  {
    return y;
  }
  public IntegerProperty zProperty()
  {
    return z;
  }

  public ObservableValue<String> updateTimeStampProperty()
  {
    return updateTimeStamp;
  }
}

package timestamp.viewmodel.textrepresentation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import timestamp.model.DataModel;

public class TextViewModel
{
  private StringProperty x;
  private StringProperty y;
  private StringProperty z;
  private StringProperty updateTimeStamp;
  private DataModel model;

  public TextViewModel(DataModel model)
  {
    this.model = model;
    x = new SimpleStringProperty();
    y = new SimpleStringProperty();
    z = new SimpleStringProperty();
    updateTimeStamp = new SimpleStringProperty();
  }

  public void updateTextFields()
  {
    double[] vals = model.getDataValues();
    x.setValue(vals[0] + "");
    y.setValue(vals[1] + "");
    z.setValue(vals[2] + "");
    updateTimeStamp.setValue(model.getLastUpdateTimeStamp());
  }

  public void saveChanges()
  {
    double newX = Double.parseDouble(x.getValue());
    double newY = Double.parseDouble(y.getValue());
    double newZ = Double.parseDouble(z.getValue());
    model.saveData(newX, newY, newZ);
  }

  public StringProperty xProperty()
  {
    return x;
  }

  public StringProperty yProperty()
  {
    return y;
  }

  public StringProperty zProperty()
  {
    return z;
  }

  public StringProperty updateProperty()
  {
    return updateTimeStamp;
  }
}

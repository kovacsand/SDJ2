package uppercase.view.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import uppercase.model.TextConverter;

public class UppercaseViewModel
{
  private TextConverter model;

  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;

  public UppercaseViewModel(TextConverter model)
  {
    this.model = model;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert()
  {
    if (request.getValue() == null || request.getValue().equals(""))
      error.setValue("Invalid request");
    else
    {
      reply.setValue(model.toUppercase(request.getValue() + ""));
      error.setValue("");
    }
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public StringProperty requestProperty()
  {
    return request;
  }

  public StringProperty replyProperty()
  {
    return reply;
  }
}
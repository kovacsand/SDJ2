package uppercase.view.log;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uppercase.model.TextConverter;

public class LogViewModel
{
  private TextConverter model;
  private ObservableList<String> logs;

  public LogViewModel(TextConverter model)
  {
    this.model = model;
    logs = FXCollections.observableArrayList();
  }

  public ObservableList<String> getLogs()
  {
    return logs;
  }

  public void loadLogs()
  {
    logs.addAll(model.getLog());
  }
}

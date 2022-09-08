package uppercase.view.log;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import uppercase.core.ViewHandler;

import java.io.IOException;

public class LogViewController
{
  @FXML private ListView<String> logList;

  private ViewHandler viewHandler;
  private LogViewModel viewModel;

  public void init(ViewHandler viewHandler, LogViewModel viewModel)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    logList.setItems(viewModel.getLogs());
    viewModel.loadLogs();
  }

  public void onBack() throws IOException
  {
    viewHandler.openToView("Uppercase");
    logList.getItems().clear();
  }
}

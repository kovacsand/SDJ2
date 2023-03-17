package timestamp.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import timestamp.viewmodel.TimestampViewModel;
//import timestamp.viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML
    Label eventLabel;
    @FXML Label numberOfUpdatesLabel;

    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdatesLabel.textProperty().bind(viewModel.numberOfUpdatesProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateTimestamp();
    }
}

package TimeStamp.client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import TimeStamp.client.viewmodel.TimestampViewModel;
//import viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML
    Label eventLabel;
    @FXML
    Label numberOfUpdates;


    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdatesProperty());

    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updateTimestamp();
    }
}

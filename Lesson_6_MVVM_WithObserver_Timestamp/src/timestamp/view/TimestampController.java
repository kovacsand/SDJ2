package timestamp.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import timestamp.viewmodel.TimestampViewModel;

import java.beans.PropertyChangeEvent;
//import timestamp.viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML
    Label eventLabel;
    @FXML
    Label numberOfUpdates;

    @FXML Circle circle;

    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdatesProperty());
        circle.fillProperty().bind(viewModel.paintProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.increaseNumberOfUpdates();
    }
}

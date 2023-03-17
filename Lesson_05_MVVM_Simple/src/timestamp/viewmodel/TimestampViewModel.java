package timestamp.viewmodel;

import timestamp.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private DataModel model;

    private StringProperty numberOfUpdates;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("Number of updates: ");
    }

    public void updateTimestamp() {
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
        model.increaseNumberOfUpdates();
        numberOfUpdates.setValue("Number of updates: " + model.getNumberOfUpdates());
    }

    public StringProperty updateTimeStampProperty() {

        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty()
    {
        return numberOfUpdates;
    }
}

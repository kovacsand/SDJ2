package timestamp.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Paint;
import timestamp.model.DataModel;
import timestamp.model.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;

public class TimestampViewModel {

    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private DataModel model;

    private Property<Paint> paintProperty;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates=new SimpleStringProperty("0");
        model.addPropertyChangeListener(evt -> this.propertyChange(evt));
        paintProperty = new SimpleObjectProperty<>();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> {
            if ("Updated".equals(evt.getPropertyName()))
            {
                updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
                numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
            }
            else if ("Colour".equals(evt.getPropertyName()))
            {
                Paint newColour = Paint.valueOf(evt.getNewValue() + "");
                paintProperty.setValue(newColour);
            }
        });
    }

    public void increaseNumberOfUpdates()
    {
        model.increaseNumberOfUpdates();
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    public Property<Paint> paintProperty()
    {
        return paintProperty;
    }
}

package temperaturemvvm.view.temperature;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;
import temperaturemvvm.core.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;
   private ViewHandler viewHandler;
   private TemperatureViewModel viewModel;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureViewModel viewModel)
   {
      this.viewHandler = viewHandler;
      this.viewModel = viewModel;
      // TODO: Statements to bind to viewModel properties

      filterLabel.textProperty().bindBidirectional(viewModel.idProperty());
      outputLabel.textProperty().bindBidirectional(viewModel.temperatureProperty());

   }

   public void reset()
   {
      // empty
   }

   @FXML private void updateButtonPressed()
   {
      viewModel.getValue();
   }

   @FXML private void onFilter()
   {
      viewModel.updateThermometerId();
   }

   @Override public void propertyChange(PropertyChangeEvent evt)
   {
      Platform.runLater(() -> {
         outputLabel.setText(evt.getNewValue().toString());
      });
   }
}

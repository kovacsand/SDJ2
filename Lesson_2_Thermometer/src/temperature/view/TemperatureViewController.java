package temperature.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;
   private TemperatureModel model;
   private Region root;
   private String thermometerId;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureModel model, Region root)
   {
      this.viewHandler = viewHandler;
      this.model = model;
      this.root = root;
      thermometerId = null;
   }

   public void reset()
   {
      // empty
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
      Temperature t = model.getLastInsertedTemperature(thermometerId);
      if (t != null)
      {
         outputLabel.setText(t.toString());
      }
      else
      {
         outputLabel.setText("No data");
      }
   }

   @FXML private void onFilter()
   {
      String oldValue = filterLabel.getText();
      if (oldValue.equals("All"))
      {
         oldValue = null;
      }
      thermometerId = filterField.getText();
      if (thermometerId.isEmpty())
      {
         thermometerId = null;
         filterLabel.setText("All");
      }
      else
      {
         filterLabel.setText(thermometerId);
         if (thermometerId == "2")
            model.removeListener("1", this);
         else
            model.removeListener("2", this);
         model.addListener(thermometerId, this);
      }
      filterField.setText(null);
      updateButtonPressed();
   }

   @Override public void propertyChange(PropertyChangeEvent evt)
   {
      Platform.runLater(() -> {
         outputLabel.setText(evt.getNewValue().toString());
      });
   }
}

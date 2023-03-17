package Data_Representation;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChartsController implements PropertyChangeListener
{
  @FXML private BarChart barChart;

  private DataModel dataModel;
  private ChartsController chartsController;

  public void initialize()
  {
    //Initial update to chart
    updateBarChart(new int[] {10, 10, 10});
    dataModel = new DataModel();
    chartsController = new ChartsController();
    dataModel.addPropertyChangeListener(chartsController);
    System.out.println("Init done");
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    int[] data = (int[]) evt.getNewValue();
    System.out.println("data received " + data[0] + data[1] + data[2]);

    updateBarChart(data);
  }

  public void generateData()
  {
    while (true)
    {
      System.out.println("calculating data");
      dataModel.recalculateData();
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void buttonOnClick()
  {
    updateBarChart(dataModel.recalculateData());
  }

  private void updateBarChart(int[] data)
  {
    System.out.println(
        barChart == null ? "the barChart is null" : "the barChart is not null");

    System.out.println("we are trying to update the chart");

    if (barChart != null)
    {
      barChart.getData().clear();

      XYChart.Series dataSeries = new XYChart.Series();

      dataSeries.getData().add(new XYChart.Data("Red", data[0]));
      dataSeries.getData().add(new XYChart.Data("Green", data[1]));
      dataSeries.getData().add(new XYChart.Data("Yellow", data[2]));

      barChart.getData().add(dataSeries);
      barChart.setLegendVisible(false);

      Node n = barChart.lookup(".data0.chart-bar");
      n.setStyle("-fx-bar-fill: red");
      n = barChart.lookup(".data1.chart-bar");
      n.setStyle("-fx-bar-fill: green");
      n = barChart.lookup(".data2.chart-bar");
      n.setStyle("-fx-bar-fill: yellow");
    }
  }
}

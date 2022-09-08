package timestamp.view.barchart;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import timestamp.viewmodel.barchart.BarChartViewModel;

public class BarChartController
{
  @FXML private Label eventLabel;
  @FXML private BarChart barChart;

  private BarChartViewModel viewModel;

  private XYChart.Data<String, Integer> x = new XYChart.Data<>("X", 0);
  private XYChart.Data<String, Integer> y = new XYChart.Data<>("Y", 0);
  private XYChart.Data<String, Integer> z = new XYChart.Data<>("Z", 0);

  public BarChartController()
  {

  }

  public void init(BarChartViewModel viewModel)
  {
    this.viewModel = viewModel;

    x.YValueProperty().bind(viewModel.xProperty().asObject());
    y.YValueProperty().bind(viewModel.yProperty().asObject());
    z.YValueProperty().bind(viewModel.zProperty().asObject());

    eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

    XYChart.Series yellowSeries = new XYChart.Series();
    yellowSeries.setName("X");
    yellowSeries.getData().add(x);
    barChart.getData().add(yellowSeries);

    XYChart.Series greenSeries = new XYChart.Series();
    greenSeries.setName("Y");
    greenSeries.getData().add(y);
    barChart.getData().add(greenSeries);

    XYChart.Series redSeries = new XYChart.Series();
    redSeries.setName("Z");
    redSeries.getData().add(z);
    barChart.getData().add(redSeries);
  }

  public void onUpdateButton()
  {
    viewModel.updateBarChart();
  }
}

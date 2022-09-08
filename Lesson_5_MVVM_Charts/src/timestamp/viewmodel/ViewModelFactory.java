package timestamp.viewmodel;

import timestamp.model.ModelFactory;
import timestamp.viewmodel.barchart.BarChartViewModel;
import timestamp.viewmodel.piechart.PieChartViewModel;
import timestamp.viewmodel.textrepresentation.TextViewModel;

public class ViewModelFactory
{
  private PieChartViewModel pieChartViewModel;
  private TextViewModel textViewModel;
  private BarChartViewModel barChartViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
    textViewModel = new TextViewModel(modelFactory.getDataModel());
    barChartViewModel = new BarChartViewModel(modelFactory.getDataModel());
  }

  public PieChartViewModel getPieChartViewModel()
  {
    return pieChartViewModel;
  }

  public TextViewModel getTextViewModel()
  {
    return textViewModel;
  }

  public BarChartViewModel getBarChartViewModel() {return barChartViewModel;}
}

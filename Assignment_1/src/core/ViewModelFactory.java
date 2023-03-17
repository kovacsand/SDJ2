package core;

import view.control.ControlViewModel;
import view.temperatures.TemperaturesViewModel;

public class ViewModelFactory
{
  private TemperaturesViewModel temperaturesVM;
  private ControlViewModel controlVM;

  public ViewModelFactory(ModelFactory mf)
  {
    temperaturesVM = new TemperaturesViewModel(mf.getModel());
    controlVM = new ControlViewModel(mf.getModel());
  }

  public TemperaturesViewModel getTemperaturesVM()
  {
    return temperaturesVM;
  }

  public ControlViewModel getControlVM()
  {
    return controlVM;
  }
}

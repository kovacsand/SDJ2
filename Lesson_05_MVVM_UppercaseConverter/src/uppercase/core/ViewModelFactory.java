package uppercase.core;

import uppercase.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private uppercase.core.ModelFactory mf;
  private UppercaseViewModel uppercaseVM;

  public ViewModelFactory(uppercase.core.ModelFactory mf)
  {
    this.mf = mf;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null)
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    return uppercaseVM;
  }
}

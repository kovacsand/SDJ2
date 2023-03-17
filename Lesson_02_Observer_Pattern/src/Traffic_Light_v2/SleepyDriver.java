package Traffic_Light_v2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SleepyDriver implements PropertyChangeListener
{
  private int id;

  public SleepyDriver(int id)
  {
    this.id = id;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    setLight(evt);
  }

  private void setLight(PropertyChangeEvent evt)
  {
    if ("GREEN".equals(evt.getNewValue()))
      System.out.println("Sleepy Car " + id + " starts engine and drives");
    else if ("YELLOW".equals(evt.getNewValue()))
    {
      if ("RED".equals(evt.getOldValue()))
        System.out.println("Sleepy Car " + id + " doesn't do anything");
      else
        System.out.println("Sleepy Car " + id + " slows down");
    }
    else if ("RED".equals(evt.getNewValue()))
      System.out.println("Sleepy Car " + id + " stops");
  }
}

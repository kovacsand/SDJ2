package Traffic_Light_v2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Taxi implements PropertyChangeListener
{
  private int id;

  public Taxi(int id)
  {
    this.id = id;
  }

  private void setLight(PropertyChangeEvent evt)
  {
    if ("GREEN".equals(evt.getNewValue()))
      System.out.println("Taxi " + id + " drives");
    else if ("RED".equals(evt.getNewValue()))
      System.out.println("Taxi " + id + " stops");
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    setLight(evt);
  }
}

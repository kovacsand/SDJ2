package Traffic_Light_v2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Pedestrian implements PropertyChangeListener
{
  private int id;

  public Pedestrian(int id)
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
      System.out.println("Pedestrian " + id + " waits");
    else if ("YELLOW".equals(evt.getNewValue()))
    {
      //These two should be the other way around, but it was like this in the exercise
      if ("RED".equals(evt.getOldValue()))
        System.out.println("Pedestrian " + id + " gets ready to cross");
      else
        System.out.println("Pedestrian " + id + " runs faster across the road");
    }
    else if ("RED".equals(evt.getNewValue()))
      System.out.println("Pedestrian " + id + " crosses the road");
  }
}

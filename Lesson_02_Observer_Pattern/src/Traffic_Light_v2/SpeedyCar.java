package Traffic_Light_v2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SpeedyCar implements PropertyChangeListener
{
  private int id;

  public SpeedyCar(int id)
  {
    this.id = id;
  }

  public void setLight(PropertyChangeEvent evt) {
    if("GREEN".equals(evt.getNewValue())) {
      System.out.println("Speedy Car " + id + " drives");
    } else if("YELLOW".equals(evt.getNewValue())) {
      if("RED".equals(evt.getOldValue())) {
        System.out.println("Speedy Car " + id + " drives at yellow");
      } else {
        System.out.println("Speedy Car " + id + " speeds up to run yellow light");
      }
    } else if("RED".equals(evt.getNewValue())) {
      System.out.println("Speedy Car " + id + " stops");
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    setLight(evt);
  }
}

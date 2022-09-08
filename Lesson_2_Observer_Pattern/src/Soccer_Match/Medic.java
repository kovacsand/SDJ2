package Soccer_Match;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Medic implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().contains("RoughTackle"))
      System.out.println("Medics run to the injured");
  }
}

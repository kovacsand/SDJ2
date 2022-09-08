package Bird_Watching;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BirdWatcher implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("WingFlap"))
      System.out.println("Would you look at that!");
    else if (evt.getPropertyName().equals("Singing"))
      System.out.println("That sounds beautiful");
  }
}

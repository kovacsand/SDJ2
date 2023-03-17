package Bird_Watching;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BlindBirdWatcher implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("Singing"))
      System.out.println("It sounds so calming. I wish I could see it...");
  }
}

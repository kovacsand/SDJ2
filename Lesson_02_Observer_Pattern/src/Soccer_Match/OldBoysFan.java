package Soccer_Match;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Old Boys Fans: YEAAAAH!");
    else if (evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Old Boys Fans: Booooo!");
  }
}

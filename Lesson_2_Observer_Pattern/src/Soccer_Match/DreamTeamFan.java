package Soccer_Match;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("DreamTeamScore"))
      System.out.println("Dream Team Fans: YEAAAAH!");
    else if (evt.getPropertyName().equals("OldBoysScore"))
      System.out.println("Dream Team Fans: Booooo!");
  }
}

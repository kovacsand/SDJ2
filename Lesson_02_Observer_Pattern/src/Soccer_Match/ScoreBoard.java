package Soccer_Match;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScoreBoard implements PropertyChangeListener
{
  private int dreamTeamPoints, odlBoysPoints;

  public ScoreBoard()
  {
    dreamTeamPoints = 0;
    odlBoysPoints = 0;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("DreamTeamScore"))
      dreamTeamPoints++;
    else if (evt.getPropertyName().equals("OldBoysScore"))
      odlBoysPoints++;
    if (evt.getPropertyName().contains("Score"))
      System.out.printf("DT %d - %d OB\n", dreamTeamPoints, odlBoysPoints);
  }
}

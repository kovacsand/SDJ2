package Soccer_Match;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoach implements PropertyChangeListener
{
  private int team;
  private String teamName;

  public AngryCoach(int team)
  {
    this.team = team;
    if (team == 0)
      teamName = "Dream Team";
    else
      teamName = "Old Boys";
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().contains("Score"))
    {
      if ((int) evt.getNewValue() == team)
        System.out.println("Angry coach of the " + teamName + " cheers");
    }
    else if (evt.getPropertyName().contains("RoughTackle"))
      if ((int) evt.getNewValue() != team)
        System.out.println("Angry coach of the " + teamName + " yells at the judge");
  }
}

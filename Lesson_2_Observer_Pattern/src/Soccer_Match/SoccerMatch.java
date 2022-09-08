package Soccer_Match;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject{

  private PropertyChangeSupport support;
  private String team0 = "Dream Team";
  private String team1 = "Old Boys";

  public SoccerMatch()
  {
    support = new PropertyChangeSupport(this);
  }

  public void startMatch()
  {
    System.out.println("Match starting \n\n");
    Random random = new Random();
    for(int i = 0; i < 90; i++)
    {
      int rand = random.nextInt(100);
      int whichTeam = random.nextInt(2);

      if(rand < 8)
        scoreGoal(whichTeam);
      else if(rand < 12)
        roughTackle(whichTeam);

      try
      {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        break;
      }
    }
    System.out.println("\n\nMatch ended");
  }

  private void roughTackle(int whichTeam) {
    if(whichTeam == 0) {
      support.firePropertyChange("DreamTeamRoughTackle", null, whichTeam);
    } else {
      support.firePropertyChange("OldBoysRoughTackle", null, whichTeam);
    }
  }

  private void scoreGoal(int whichTeam) {
    if(whichTeam == 0) {
      support.firePropertyChange("DreamTeamScore", 1, whichTeam);
    } else {
      support.firePropertyChange("OldBoysScore", 0, whichTeam);
    }
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}

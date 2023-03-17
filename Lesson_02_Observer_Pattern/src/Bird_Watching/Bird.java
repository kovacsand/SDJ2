package Bird_Watching;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Bird implements PropertyChangeSubject
{
  private PropertyChangeSupport support;

  public Bird()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  public void live()
  {
    System.out.println("Bird living their everyday life");
    Random random = new Random();
    for (int i = 0; i < 5; i++)
    {

      int rand = random.nextInt(2);

      if (rand == 0)
        flapWings();
      else if (rand == 1)
        sing();

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        break;
      }
    }
  }

  private void sing()
  {
    System.out.println("Peacock whistles");
    support.firePropertyChange("Singing", 0, 1);
  }

  private void flapWings()
  {
    System.out.println("Peacock flashes its wings");
    support.firePropertyChange("WingFlap", 0, 1);
  }
}

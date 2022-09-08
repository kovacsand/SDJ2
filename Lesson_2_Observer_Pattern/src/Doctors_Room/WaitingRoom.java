package Doctors_Room;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements PropertyChangeSubject, Runnable
{
  private PropertyChangeSupport support;

  public WaitingRoom()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  private void numberChanged(int current)
  {
    support.firePropertyChange("NumberChanged", null, current);

  }

  public void run()
  {
    for (int i = 0; i < 10; i++) {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("\nDiing! Current number is " + i);
      numberChanged(i);
    }
  }
}

package external.radiator;

import util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements Subject
{
  private RadiatorState currentState;
  private final PropertyChangeSupport support;

  public Radiator()
  {
    currentState = new OffState();
    support = new PropertyChangeSupport(this);
  }

  public void turnUp()
  {
    currentState.turnUp(this);
  }

  public void turnDown()
  {
    currentState.turnDown(this);
  }

  public int getPower()
  {
    return currentState.getPower();
  }

  void setPowerState(RadiatorState state)
  {
    currentState = state;
    support.firePropertyChange("Radiator changed", null, getPower());
  }

  @Override public void addListener(String propertyName, PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
      support.addPropertyChangeListener(listener);
    else // a specific event
      support.addPropertyChangeListener(propertyName, listener);
  }

  @Override public void removeListener(String propertyName, PropertyChangeListener listener)
  {
    if (propertyName == null)
      support.removePropertyChangeListener(listener);
    else //a specific event
      support.removePropertyChangeListener(propertyName, listener);
  }
}

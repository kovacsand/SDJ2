package mediator;

import external.Thermometer;
import external.radiator.Radiator;
import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel, PropertyChangeListener
{
  private TemperatureList temperatureList;
  private Radiator radiator;
  private Thermometer t1, t2;

  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  private double criticalLow;
  private double criticalHigh;

  public TemperatureModelManager()
  {
    criticalLow = 15;
    criticalHigh = 30;
    temperatureList = new TemperatureList();
    radiator = new Radiator();
    t1 = new Thermometer(this, "t1", 10, 1);
    t2 = new Thermometer(this, "t2", 10, 7);
    radiator.addListener("Radiator changed", t1);
    radiator.addListener("Radiator changed", t2);
    radiator.addListener("Radiator changed", this);
    Thread thread1 = new Thread(t1);
    Thread thread2 = new Thread(t2);
    thread1.start();
    thread2.start();
  }

  public double getCriticalLow()
  {
    return criticalLow;
  }

  public double getCriticalHigh()
  {
    return criticalHigh;
  }

  public void setCriticalLow(double criticalLow)
  {
    this.criticalLow = criticalLow;
  }

  public void setCriticalHigh(double criticalHigh)
  {
    this.criticalHigh = criticalHigh;
  }

  @Override public int getRadiatorPowerState()
  {
    return radiator.getPower();
  }

  @Override public void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature();
    this.temperatureList.addTemperature(temperature);
    support.firePropertyChange(id, null, temperature);
    System.out.println("-->" + temperature + " Radiator power: " + radiator.getPower() + " (from: " + old + ")");
  }

  @Override public Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public Temperature getLastInsertedTemperature(String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void turnDownRadiator()
  {
    radiator.turnDown();
  }

  @Override public void turnUpRadiator()
  {
    radiator.turnUp();
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

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    support.firePropertyChange(null, "Old radiator state", evt.getNewValue());
  }
}

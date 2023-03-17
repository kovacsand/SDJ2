package external;

import mediator.TemperatureModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

public class Thermometer implements Runnable, PropertyChangeListener
{
  private String id;
  private double t;
  private int d;
  private int radiatorState;

  //It's Denmark...
  private final double OUTDOOR_TEMPERATURE = 10.0;

  private TemperatureModel model;

  public Thermometer(TemperatureModel model, String id, double t, int d)
  {
    this.model = model;
    this.id = id;
    this.t = t;
    this.d = d;
    this.radiatorState = 0;
  }

  private double temperature(double t, int p, int d, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }

  @Override public void run()
  {
    while (true)
    {
      t = temperature(t, radiatorState, d, OUTDOOR_TEMPERATURE, new Random().nextInt(8 - 4 + 1) + 4);
      model.addTemperature(id, t);
      try
      {
        Thread.sleep((new Random().nextInt(8 - 4 + 1) + 4) * 1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    this.radiatorState = (int) evt.getNewValue();
  }
}

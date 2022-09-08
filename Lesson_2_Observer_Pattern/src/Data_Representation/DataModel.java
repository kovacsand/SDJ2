package Data_Representation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class DataModel implements PropertyChangeSubject
{

  private PropertyChangeSupport support;

  private int red, green, yellow;

  private Random random = new Random();

  public DataModel()
  {
    support = new PropertyChangeSupport(this);
  }

  public int[] recalculateData()
  {
    int first = random.nextInt(100) + 1;
    int second = random.nextInt(100) + 1;
    int bottom = Math.min(first, second);
    int top = Math.max(first, second);

    red = bottom;
    green = top - bottom;
    yellow = 100 - top;
    System.out.println("red: " + red);
    System.out.println("green: " + green);
    System.out.println("yellow: " + yellow);
    System.out.println("Sum: " + (red + green + yellow));

    int[] data = {red, green, yellow};

    support.firePropertyChange("DataChanged", 0, data);
    return data;
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }
}

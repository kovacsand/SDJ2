package Increment;

public class Counter
{
  private int counter;

  public Counter()
  {
    counter = 0;
  }

  public synchronized void incrementCount()
  {
    counter++;
  }

  public int getCounter()
  {
    synchronized (this)
    {
      return counter;
    }
  }
}

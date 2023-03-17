package TwoCounters;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int countDooku, countDracula;
  private Lock lock1 = new ReentrantLock();
  private Lock lock2 = new ReentrantLock();

  public Counter()
  {
    countDooku = 0;
    countDracula = 0;
  }

  public void incrementCountDooku()
  {
    synchronized (lock1)
    {
      countDooku++;
    }
  }

  public void incrementCountDracula()
  {
    synchronized (lock2)
    {
      countDracula++;
    }
  }

  public int getCountDooku()
  {
    synchronized (lock1)
    {
      return countDooku;
    }
  }

  public int getCountDracula()
  {
    synchronized (lock2)
    {
      return countDracula;
    }
  }
}

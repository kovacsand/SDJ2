package Carrots.v2;

import Carrots.Carrot;

import java.util.ArrayDeque;
import java.util.Queue;

public class Monitor
{
  private Queue queue;
  private final int capacity;
  private int whenToStartPeeling = 4;

  public Monitor(int capacity)
  {
    queue = new ArrayDeque(capacity);
    this.capacity = capacity;
  }

  public synchronized void peel() throws InterruptedException
  {
    while (size() == capacity)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
      queue.add(new Carrot());
    notifyAll();
  }

  public synchronized Object eat()
  {
    while (size() == 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    if (size() == whenToStartPeeling)
      notifyAll();
    return queue.remove();
  }

  public int size()
  {
    return queue.size();
  }

  public String toString()
  {
    return String.format("There are %d element(s) in the queue. Maximum size is: %d\n%s", queue.size(), capacity, queue);
  }
}

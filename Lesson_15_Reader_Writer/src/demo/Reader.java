package demo;

import java.util.Random;

public class Reader implements Runnable
{
  private ReadersWriters lock;

  public Reader(ReadersWriters lock)
  {
    this.lock = lock;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Thread.sleep(new Random().nextInt(1000) + 500);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println(lock.safeRead());
    }
  }
}

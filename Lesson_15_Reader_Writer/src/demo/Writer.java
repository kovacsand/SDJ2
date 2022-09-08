package demo;

import java.util.Random;

public class Writer implements Runnable
{
  private ReadersWriters lock;

  public Writer(ReadersWriters lock)
  {
    this.lock = lock;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Thread.sleep(new Random().nextInt(2000) + 5000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      lock.acquireWrite();
      lock.write();
      lock.releaseWrite();
    }
  }
}

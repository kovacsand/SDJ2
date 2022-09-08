package demo;

import java.util.Random;

public class WriterPreference implements ReadersWriters
{
  private int data = 0;
  private int noReaders = 0, noWriters = 0, noWaitingReaders = 0, noWaitingWriters = 0;

  private int read()
  {
    try
    {
      Thread.sleep(new Random().nextInt(5000) + 2000);    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return data;
  }

  @Override public int safeRead()
  {
    acquireRead();
    int data = read();
    releaseRead();
    return data;
  }

  @Override public void write()
  {
    try
    {
      Thread.sleep(new Random().nextInt(1500) + 1250);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    data++;
  }

  @Override public synchronized void acquireRead()
  {
    noWaitingReaders++;
    while (noWriters > 0 || noWaitingWriters > 0)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " waiting to read");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    System.out.println(Thread.currentThread().getName() + " acquired read lock | readers count: " + noReaders);
    noReaders++;
  }

  @Override public synchronized void releaseRead()
  {
    noReaders--;
    System.out.println(Thread.currentThread().getName() + " release read lock | readers count: " + noReaders);

    if (noReaders == 0)
      notify(); //notify one waiting writer
  }

  @Override public synchronized void acquireWrite()
  {
    noWaitingWriters++;
    while (noReaders > 0 || noWriters > 0)
    {
      try
      {
        System.out.println(Thread.currentThread().getName() + " waiting to write");
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    noWaitingWriters--;
    System.out.println(Thread.currentThread().getName() + " acquired write lock | waiting writers count: " + noWaitingWriters);
    noWriters++;
  }

  @Override public synchronized void releaseWrite()
  {
    noWriters--;
    System.out.println(Thread.currentThread().getName() + " release write lock | waiting writers count: " + noWaitingWriters);
    notifyAll(); //notify all waiting readers
  }
}
